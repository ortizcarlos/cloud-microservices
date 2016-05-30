package co.agileventure.cloud.authorization.support;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Carlos
 */
@Component
public class AuthUtils {
    
    @Value("${authapp.secretkey}")
    private String appSecretKey;

    public String createLoginToken(String host,String userName,String email) {
        return Jwts.builder()
                .setSubject(userName)
                .claim("roles", "user")
                .claim("email", email)
                .setIssuer(host)
                .setIssuedAt(DateTime.now().toDate())
                .signWith(SignatureAlgorithm.HS256, appSecretKey).compact();
    }
}
