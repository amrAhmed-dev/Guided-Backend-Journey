# Auth0 token script (PKCE)

Logs in through Auth0's hosted login page and prints an access token for the BusTicket API.
Flow: Authorization Code + PKCE, exchange done with the `auth0` Node SDK (v4 API).

## Setup

```bash
cd scripts/auth0-token
npm install
```

`AUDIENCE` is set to `http://localhost:8080`, the same value as `audiences` in `application.yml`. It must equal the API Identifier in Auth0
(Auth0 dashboard > Applications > APIs > your API > Identifier).

## Run

```bash
node get-token.mjs                       # browser opens, log in with email/password
TOKEN=$(node get-token.mjs 2>/dev/null)  # capture only the token
curl -H "Authorization: Bearer $TOKEN" http://localhost:8080/api/admin/fares/1
```

The token is printed on stdout; everything else (decoded claims, expiry, hints) goes to stderr.

## Auth0 dashboard checklist

- Applications > your app > Settings > **Allowed Callback URLs** contains `http://localhost:3000/callback`.
- Applications > your app > Advanced Settings > Grant Types: **Authorization Code** is checked.
- Applications > APIs > your API > **Identifier** equals `http://localhost:8080` (the `AUDIENCE` in the script). If it differs, change `AUDIENCE` and `audiences` in `application.yml` together.
- Optional: on that API enable **Allow Skipping User Consent** to avoid the consent screen on every run.

## Troubleshooting

- `access_denied: Service not found: ...` means `AUDIENCE` does not match any API in the tenant.
- Browser shows Auth0's "Callback URL mismatch" page and the script times out: add the callback URL above.
- Token is opaque (not a JWT): `AUDIENCE` was not applied; the script warns about this.
