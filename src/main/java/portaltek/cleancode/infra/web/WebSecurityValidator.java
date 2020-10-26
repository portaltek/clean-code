package portaltek.cleancode.infra.web;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import portaltek.cleancode.module.security.core.published.service.JwtService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static java.util.Optional.ofNullable;
import static org.springframework.security.core.context.SecurityContextHolder.getContext;

@Service
class WebSecurityValidator {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private JwtService jwtService;

    @Value("${jwt.header}")
    private String tokenHeader;
    @Value("${jwt.refresh.header}")
    private String refreshTokenHeader;


    public void validate(HttpServletRequest request) {

        ofNullable(request.getHeader(tokenHeader))
                .filter(jwtService::hasToken)
                .filter(e -> getContext().getAuthentication() == null)
                .map(e -> e.substring(7))
                .ifPresent(e -> validateToken(request, e));

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
        getContext().setAuthentication(auth);
    }


}