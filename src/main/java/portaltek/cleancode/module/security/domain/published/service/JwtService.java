package portaltek.cleancode.module.security.domain.published.service;


import io.jsonwebtoken.Claims;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import portaltek.cleancode.module.security.api.web.token.JwtResponse;

import java.util.Date;
import java.util.List;


public interface JwtService {

    public String getIdFromToken(String token);

    public Long getUserIdFromToken(String token);

    public String getUsernameFromToken(String token);

    public List<SimpleGrantedAuthority> getRolesFromToken(String token);

    public Date getCreatedDateFromToken(String token);

    public Date getExpirationDateFromToken(String token);

//    public String getAudienceFromToken(String token);

    public Claims getClaimsFromToken(String token);

    public Boolean isTokenExpired(String token);

    public Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset);

//    public String generateAudience(Device device);

//    public Boolean ignoreTokenExpiration(String token);

    public JwtResponse generateToken(String username);

    public JwtResponse refreshToken(String token);

    public Boolean validateToken(String token);

//    public UserDetails getUserDetailsFromToken(String token);

    boolean hasToken(String header);

}
