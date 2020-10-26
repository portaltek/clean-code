package portaltek.cleancode.module.security.core.published.service;


import io.jsonwebtoken.Claims;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import portaltek.cleancode.module.security.api.web.token.JwtResponse;

import java.util.Date;
import java.util.List;


public interface JwtService {

    String getIdFromToken(String token);

    Long getUserIdFromToken(String token);

    String getUsernameFromToken(String token);

    List<SimpleGrantedAuthority> getRolesFromToken(String token);

    Date getCreatedDateFromToken(String token);

    Date getExpirationDateFromToken(String token);

    Claims getClaimsFromToken(String token);

    Boolean isTokenExpired(String token);

    Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset);

    JwtResponse generateToken(String username);

    JwtResponse refreshToken(String token);

    Boolean validateToken(String token);

    boolean hasToken(String header);

}
