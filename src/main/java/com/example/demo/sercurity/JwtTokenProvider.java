package com.example.demo.sercurity;
import com.example.demo.model.AppUserDetail;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {
    private final String JWT_SECRET = "timebird";
    private final long JWT_EXPIRE = 604800000L;

    // Tạo ra jwt từ thông tin user
    public String generateToken(AppUserDetail userDetail){
        Date now = new Date();
        Date expire = new Date(now.getTime() + JWT_EXPIRE);
        return Jwts.builder().setSubject(Long.toString(userDetail.getAppUser().getId())).setIssuedAt(now).
                setExpiration(expire).signWith(SignatureAlgorithm.HS512, JWT_SECRET).compact();
    }
    // Lấy thông tin user từ jwt
    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
        return false;
    }
}
