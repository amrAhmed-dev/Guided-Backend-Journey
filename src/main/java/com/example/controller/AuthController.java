package com.example.controller;

import com.auth0.client.auth.AuthAPI;
import com.auth0.exception.Auth0Exception;
import com.auth0.json.auth.TokenHolder;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthAPI authAPI;
    private final String realm;

    public AuthController(
            @Value("${auth0.domain}") String domain,
            @Value("${auth0.clientId}") String clientId,
            @Value("${auth0.clientSecret}") String clientSecret,
            @Value("${auth0.realm}") String realm) {
        this.authAPI = AuthAPI.newBuilder(domain, clientId, clientSecret).build();
        this.realm = realm;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body, HttpServletRequest request) {
        try {
            String email = body.get("email");
            String password = body.get("password");

            TokenHolder holder = authAPI.login(email, password.toCharArray())
                    .setRealm("Username-Password-Authentication")
                    .setScope("openid profile email")
                    .execute()
                    .getBody();

            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                    email, null, List.of(new SimpleGrantedAuthority("ROLE_USER"))
            );
            SecurityContext context = SecurityContextHolder.createEmptyContext();
            context.setAuthentication(auth);
            SecurityContextHolder.setContext(context);
            request.getSession(true).setAttribute(
                    HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, context
            );

            return ResponseEntity.ok(Map.of("message", "Login Successful!"));

        } catch (Auth0Exception e) {
//        e.printStackTrace(); this is for my test in the consonle
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(Map.of("Error", "Invalid credentials: " + e.getMessage()));
    }
}
}
