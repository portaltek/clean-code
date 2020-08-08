package portaltek.cleancode.api.security.service;


import io.jsonwebtoken.Claims;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import portaltek.cleancode.api.security.controller.dto.JwtAuthenticationResponse;

import java.util.Date;
import java.util.List;


public interface JwtUtil {
	
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

    public JwtAuthenticationResponse generateToken(String username);

    public JwtAuthenticationResponse refreshToken(String token);

    public Boolean validateToken(String token);
    
//    public UserDetails getUserDetailsFromToken(String token);
}
