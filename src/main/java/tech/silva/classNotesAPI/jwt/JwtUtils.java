package tech.silva.classNotesAPI.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class JwtUtils {


    public static final String JWT_BEARER = "Bearer ";
    public static final String JWT_AUTHORIZATION = "Authorization";
    public static final String SECRET_KEY = "0123456789-0123456789-0123456789";
    public static final long EXPIRE_DAYS = 0;
    public static final long EXPIRE_HOURS = 2;
    public static final long EXPIRE_MINUTES = 30;

    private JwtUtils() {
    }

    private static SecretKey generateKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    private static Date toExpireDate(Date start) {
        LocalDateTime dateTime = start.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime end = dateTime.plusDays(EXPIRE_DAYS).plusHours(EXPIRE_HOURS).plusMinutes(EXPIRE_MINUTES);
        return Date.from(end.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static JwtToken createToken(String username, String role) {
        Date issuedAt = new Date();
        Date limit = toExpireDate(issuedAt);

        String token = Jwts.builder()
                .header().add("typ", "JWT")
                .and()
                .subject(username)
                .issuedAt(issuedAt)
                .expiration(limit)
                .signWith(generateKey(), Jwts.SIG.HS256)
                .claim("role", role)
                .compact();

        return new JwtToken(token);
    }

    private static String refactorToken(String token) {
        if (token.contains(JWT_BEARER)) {
            return token.substring(JWT_BEARER.length());
        }
        return token;
    }

    private static Claims getClaimsFromToken(String token) {
        try {
            return Jwts.parser()
                    .verifyWith(generateKey())
                    .build().parseSignedClaims(refactorToken(token)).getPayload();
        } catch (JwtException ex) {
        }
        return null;
    }

    public static boolean isTokenValid(String token) {
        try {
            Jwts.parser()
                    .verifyWith(generateKey())
                    .build().parseSignedClaims(refactorToken(token));
            return true;
        } catch (JwtException ex) {
        }
        return false;
    }

    public static String getUsernameFromToken(String token) {
        return getClaimsFromToken(token).getSubject();
    }

}
