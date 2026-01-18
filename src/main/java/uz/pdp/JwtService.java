package uz.pdp;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Service
public class JwtService {

    private static final String SECRET =
            "my-super-secret-key-my-super-secret-key"; // min 32 chars

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor( SECRET.getBytes() );
    }

    public boolean isTokenValid( String token ) {
        try {
            extractAllClaims( token );
            return true;
        } catch ( Exception e ) {
            return false;
        }
    }

    public String extractUsername( String token ) {
        return extractAllClaims( token ).getSubject();
    }

    @SuppressWarnings("unchecked")
    public List<String> extractRoles( String token ) {
        return extractAllClaims( token ).get( "roles", List.class );
    }

    private Claims extractAllClaims( String token ) {
        return Jwts.parserBuilder()
                .setSigningKey( getSigningKey() )
                .build()
                .parseClaimsJws( token )
                .getBody();
    }

    /* Optional: token generation */
    public String generateToken( String username, List<String> roles ) {
        return Jwts.builder()
                .setSubject( username )
                .claim( "roles", roles )
                .setIssuedAt( new Date() )
                .setExpiration( new Date( System.currentTimeMillis() + 3600000 ) )
                .signWith( getSigningKey() )
                .compact();
    }
}
