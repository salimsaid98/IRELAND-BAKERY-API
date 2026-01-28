package com.example.api_bakery.Jwt;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "hadimu@1963"; // Replace with your secure key
    private final long ACCESS_TOKEN_EXPIRATION_TIME = 60000; // 1 minute in milliseconds
    private final long REFRESH_TOKEN_EXPIRATION_TIME = 3600000; // 1 hour in milliseconds

    // Generate Token using only the username
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username) // Store username as the subject
                .setIssuedAt(new Date()) // Current date
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRATION_TIME )) // Expiration time
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY) // Sign the token
                .compact();
    }
       // Generate Token using only the username
       public String generateRefreshToken(String username) {
        return Jwts.builder()
                .setSubject(username) // Store username as the subject
                .setIssuedAt(new Date()) // Current date
                .setExpiration(new Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRATION_TIME )) // Expiration time
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY) // Sign the token
                .compact();
    }

    // Extract Claims from Token
    public Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY) // Set the secret key
                .parseClaimsJws(token)
                .getBody(); // Extract the claims body
    }

    // Extract Username from Token
    public String extractUsername(String token) {
        return extractClaims(token).getSubject(); // Extract the subject (username)
    }

    // Validate Token using only the username
    public boolean isTokenValid(String token, String username) {
        String tokenUsername = extractUsername(token); // Extract username from token
        return username.equals(tokenUsername) && !isTokenExpired(token); // Check validity
    }

    // Check if Token is Expired
    public boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date()); // Compare expiration date
    }
}