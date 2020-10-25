package portaltek.cleancode.module.security.domain.jwt;


import io.jsonwebtoken.*;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import portaltek.cleancode.module.security.api.web.token.JwtResponse;
import portaltek.cleancode.module.security.domain.published.service.JwtService;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;


class JwtServiceImpl implements JwtService, Serializable {

    private static final long serialVersionUID = -3301605591108950415L;

    static final String CLAIM_KEY_ID = "jti";
    static final String CLAIM_KEY_USERID = "userId";
    static final String CLAIM_KEY_USERNAME = "sub";
    static final String CLAIM_KEY_CREATED = "created";
    static final String CLAIM_KEY_ROLES = "roles";
    static final String BEARER = "Bearer ";

    private String secret;
    private Long expiration;
    private UserDetailsService userDetailsService;

    public JwtServiceImpl(String secret,
                          Long expiration,
                          UserDetailsService userDetailsService) {
        this.secret = secret;
        this.expiration = expiration;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public String getIdFromToken(String token) {
        try {
            final Claims claims = getClaimsFromToken(token);
            return claims.getId();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Long getUserIdFromToken(String token) {
        try {
            final Claims claims = getClaimsFromToken(token);
            return Long.parseLong(claims.get(CLAIM_KEY_USERID).toString());
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getUsernameFromToken(String token) {
        try {
            final Claims claims = getClaimsFromToken(token);
            return claims.getSubject();
        } catch (Exception e) {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<SimpleGrantedAuthority> getRolesFromToken(String token) {
        List<String> roles;
        try {
            final Claims claims = getClaimsFromToken(token);
            roles = (List<String>) claims.get(CLAIM_KEY_ROLES);
        } catch (Exception e) {
            roles = null;
        }
        return roles != null ? roles.stream()
                .map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList()) : null;
    }

    @Override
    public Date getCreatedDateFromToken(String token) {
        try {
            final Claims claims = getClaimsFromToken(token);
            return new Date((Long) claims.get(CLAIM_KEY_CREATED));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Date getExpirationDateFromToken(String token) {
        try {
            final Claims claims = getClaimsFromToken(token);
            return claims.getExpiration();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Claims getClaimsFromToken(String token) throws ExpiredJwtException, UnsupportedJwtException,
            MalformedJwtException, SignatureException, IllegalArgumentException {

        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

    }


    private Date generateExpirationDate(String type) {
        if (type.equals("token")) {
            return new Date(System.currentTimeMillis() + expiration * 1000);
        } else {
            return new Date(System.currentTimeMillis() + expiration * 5 * 1000);
        }
    }

    @Override
    public Boolean isTokenExpired(String token) {
        try {
            getClaimsFromToken(token);
            return false;
        } catch (ExpiredJwtException ex) {
            return true;
        }

    }

    @Override
    public Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    @Override
    public JwtResponse generateToken(String username) {

        Map<String, Object> claims = generateClaims(username);
        String token = doGenerateToken(claims);
        String refreshToken = doGenerateRefreshToken(claims);
        return new JwtResponse(token, refreshToken);
    }

    @Override
    public JwtResponse refreshToken(String username) {

        String newToken;
        String newRefreshToken;
        try {
            final Map<String, Object> claims = generateClaims(username);
            newToken = doGenerateToken(claims);
            newRefreshToken = doGenerateRefreshToken(claims);
        } catch (Exception e) {
            newToken = null;
            newRefreshToken = null;
        }
        return new JwtResponse(newToken, newRefreshToken);
    }

    private Map<String, Object> generateClaims(String username) {
        final JwtUser userDetails = (JwtUser) userDetailsService.loadUserByUsername(username);
        Map<String, Object> claims = new HashMap<>();

        claims.put(CLAIM_KEY_ID, UUID.randomUUID().toString());
        claims.put(CLAIM_KEY_USERID, userDetails.getId());
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        claims.put(CLAIM_KEY_ROLES, AuthorityUtils.authorityListToSet(userDetails.getAuthorities()));

        return claims;
    }

    private String doGenerateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate("token"))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    private String doGenerateRefreshToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate("refresh"))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    @Override
    public Boolean validateToken(String token) {
        try {
            getClaimsFromToken(token);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean hasToken(String header) {
        return header != null && header.startsWith(BEARER);
    }

}
