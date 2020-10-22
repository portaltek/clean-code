package portaltek.cleancode.core.security;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
class JwtValidator {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private JwtService jwtService;

    @Value("${jwt.header}")
    private String tokenHeader;
    @Value("${jwt.refresh.header}")
    private String refreshTokenHeader;

    boolean hasToken(String header) {
        return header != null && header.startsWith("Bearer ");
    }


    public void validate(HttpServletRequest request) {

        final String header = request.getHeader(tokenHeader);
        if (this.hasToken(header)) {
            String token = header.substring(7);
            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                validateToken(request, token);
            }
        }
    }


    public void validateToken(HttpServletRequest request, String token) {

        var username = jwtService.getUsernameFromToken(token);
        var authorities = jwtService.getRolesFromToken(token);
        logger.info("checking authentication for user " + username);

        if (jwtService.validateToken(token)) {
            setSecurityCtx(request, username, authorities);
        }

    }

    private void setSecurityCtx(HttpServletRequest request,
                                String username,
                                List<SimpleGrantedAuthority> authorities) {

        var auth = new UsernamePasswordAuthenticationToken(username, null, authorities);
        auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        logger.info("authenticated user " + username + ", setting security context");
        SecurityContextHolder.getContext().setAuthentication(auth);
    }


}