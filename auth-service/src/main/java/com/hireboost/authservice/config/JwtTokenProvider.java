package com.hireboost.authservice.config;


import com.hireboost.authservice.user.dto.UserDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * This class is responsible for JWT token generation and validation.
 */
@Component
public class JwtTokenProvider {
    private final SecretKey SECRET_KEY;

    public JwtTokenProvider(@Value("${jwt.secret}") final String secret) {
        this.SECRET_KEY = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Extracts the email out of the JWT token.
     *
     * @param token The token from which an email will be extracted
     * @return An email extracted from the token
     */
    public String extractEmail(final String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Extracts the expiration date from the JWT token.
     *
     * @param token The JWT token.
     * @return An expiration date.
     */
    public Date extractExpiration(final String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Extracts the value associated with the "role" key from the JWT token claims.
     *
     * @param token the JWT token from which to extract the role
     * @return the value of the "role" field extracted from the token claims
     */
    public String extractRoleFromClaims(final String token) {
        return extractClaim(token, claims -> claims.get("role", String.class));
    }

    /**
     * Extracts a specific claim from the JWT token using a resolution function.
     *
     * @param token          the JWT token from which to extract the claim
     * @param claimsResolver function that defines how to extract the claim from the claims
     * @param <R>            the type of the claim to extract
     * @return the value of the extracted claim
     */
    public <R> R extractClaim(final String token, Function<Claims, R> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Extracts all claims from the JWT token.
     *
     * @param token the JWT token from which to extract the claims
     * @return the claims extracted from the token
     */
    private Claims extractAllClaims(final String token) {
        return Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    /**
     * Checks if the JWT token is expired.
     *
     * @param token the JWT token to check
     * @return true if the token is expired, false otherwise
     */
    public Boolean isTokenExpired(final String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * Generates a new JWT token based on the AuthorizationRequest object.
     *
     * @param request the AuthorizationRequest object containing information for token generation
     * @return the generated JWT token
     */
    public String generateToken(final UserDTO request) {
        final Map<String, String> claims = new HashMap<>();
        claims.put("id", request.id().toString());
        claims.put("username", request.name());
        return createToken(claims, request.email());
    }

    /**
     * Creates a JWT token using the provided claims and specified subject.
     *
     * @param claims  the map of claims to include in the token
     * @param subject the subject of the token (e.g., the user's email); the subject acts as an identifier
     * @return the created JWT token
     */
    private String createToken(final Map<String, String> claims, final String subject) {
        return Jwts.builder()
                .claims(claims)
                .subject(subject)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SECRET_KEY)
                .compact();
    }

}