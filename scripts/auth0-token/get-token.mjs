#!/usr/bin/env node
// Auth0 Authorization Code + PKCE login from the terminal.
// Opens the Auth0 hosted login page in your browser, catches the callback on
// localhost, exchanges the code with the auth0 SDK and prints the access token.
//
// Usage:   node get-token.mjs            (token on stdout, details on stderr)
//          TOKEN=$(node get-token.mjs 2>/dev/null)

import { createServer } from "node:http";
import { randomBytes, createHash } from "node:crypto";
import { spawn } from "node:child_process";
import { AuthenticationClient } from "auth0";

// ---- Config (hardcoded on purpose, study project) -------------------------
const DOMAIN = "dev-184eafy1yj1tjocf.us.auth0.com";
const CLIENT_ID = "LXEhgjW4irZ5f4kQmew6g4vDNR6kAUCE";
const CLIENT_SECRET = "pWf26K_x-M4EnEP8iHFfTqsq5kdwQBJoVOMNAG8MekugV0wZPN1BIzx_oguAL6z7";
const AUDIENCE = "http://localhost:8080"; // must equal the API Identifier in Auth0 (matches audiences in application.yml)
const CONNECTION = "Username-Password-Authentication";
const SCOPE = "openid profile email";
const PORT = 3000;
const REDIRECT_URI = `http://localhost:${PORT}/callback`;
const TIMEOUT_MS = 2 * 60 * 1000;
// ---------------------------------------------------------------------------

const log = (...args) => console.error(...args);
const fail = (msg) => {
  log(`\nERROR: ${msg}`);
  process.exit(1);
};

if (AUDIENCE.startsWith("<")) {
  fail("Set AUDIENCE in get-token.mjs to your API Identifier (Auth0 dashboard > Applications > APIs).");
}

const b64url = (buf) => buf.toString("base64url");
const codeVerifier = b64url(randomBytes(32));
const codeChallenge = b64url(createHash("sha256").update(codeVerifier).digest());
const state = b64url(randomBytes(16));
const nonce = b64url(randomBytes(16));

const authorizeUrl =
  `https://${DOMAIN}/authorize?` +
  new URLSearchParams({
    response_type: "code",
    client_id: CLIENT_ID,
    redirect_uri: REDIRECT_URI,
    scope: SCOPE,
    audience: AUDIENCE,
    connection: CONNECTION,
    state,
    nonce,
    code_challenge: codeChallenge,
    code_challenge_method: "S256",
  }).toString();

function waitForCode() {
  return new Promise((resolve, reject) => {
    const server = createServer((req, res) => {
      const url = new URL(req.url, REDIRECT_URI);
      if (url.pathname !== "/callback") {
        res.writeHead(404).end();
        return;
      }
      const params = url.searchParams;
      const finish = (status, html, outcome) => {
        res.writeHead(status, { "Content-Type": "text/html; charset=utf-8" });
        res.end(`<!doctype html><body style="font-family:sans-serif;padding:2rem">${html}</body>`);
        clearTimeout(timer);
        server.closeAllConnections();
        server.close();
        outcome();
      };

      if (params.get("error")) {
        const msg = `${params.get("error")}: ${params.get("error_description") ?? ""}`;
        return finish(400, `<h2>Login failed</h2><p>${msg}</p>`, () => reject(new Error(msg)));
      }
      if (params.get("state") !== state) {
        return finish(400, "<h2>State mismatch</h2>", () => reject(new Error("state mismatch (possible CSRF or stale tab)")));
      }
      const code = params.get("code");
      if (!code) {
        return finish(400, "<h2>Missing code</h2>", () => reject(new Error("callback had no code parameter")));
      }
      finish(200, "<h2>Logged in. You can close this tab.</h2>", () => resolve(code));
    });

    const timer = setTimeout(() => {
      server.closeAllConnections();
      server.close();
      reject(new Error(
        `timed out after ${TIMEOUT_MS / 1000}s waiting for the callback. ` +
        `Check that "${REDIRECT_URI}" is in Allowed Callback URLs for the app.`
      ));
    }, TIMEOUT_MS);

    server.on("error", (e) => reject(new Error(`could not listen on port ${PORT}: ${e.message}`)));
    server.listen(PORT, "127.0.0.1");
  });
}

function openBrowser(url) {
  const cmd = process.platform === "darwin" ? "open" : process.platform === "win32" ? "start" : "xdg-open";
  spawn(cmd, [url], { stdio: "ignore", detached: true, shell: process.platform === "win32" }).on("error", () => {});
}

function decodeJwtPayload(jwt) {
  const parts = jwt.split(".");
  if (parts.length !== 3) return null; // opaque token (no audience matched)
  try {
    return JSON.parse(Buffer.from(parts[1], "base64url").toString("utf8"));
  } catch {
    return null;
  }
}

try {
  log("Opening browser for Auth0 login. If it does not open, visit:\n" + authorizeUrl + "\n");
  const codePromise = waitForCode();
  openBrowser(authorizeUrl);
  const code = await codePromise;
  log("Got authorization code, exchanging for tokens...");

  const auth = new AuthenticationClient({ domain: DOMAIN, clientId: CLIENT_ID, clientSecret: CLIENT_SECRET });
  const { data } = await auth.oauth.authorizationCodeGrantWithPKCE(
    { code, code_verifier: codeVerifier, redirect_uri: REDIRECT_URI },
    { idTokenValidateOptions: { nonce } }
  );

  const payload = decodeJwtPayload(data.access_token);
  if (payload) {
    log("\nAccess token payload:");
    log(JSON.stringify({ sub: payload.sub, aud: payload.aud, scope: payload.scope, iss: payload.iss,
      exp: new Date(payload.exp * 1000).toISOString() }, null, 2));
  } else {
    log("\nWARNING: access token is opaque (not a JWT). Check that AUDIENCE matches your API Identifier.");
  }
  log(`\nexpires_in: ${data.expires_in}s   token_type: ${data.token_type}`);
  log(`\nExample:\n  TOKEN=$(node get-token.mjs 2>/dev/null)\n  curl -H "Authorization: Bearer $TOKEN" http://localhost:8080/api/admin/fares/1\n`);

  process.stdout.write(data.access_token + "\n", () => process.exit(0));
} catch (err) {
  fail(err?.message ?? String(err));
}
