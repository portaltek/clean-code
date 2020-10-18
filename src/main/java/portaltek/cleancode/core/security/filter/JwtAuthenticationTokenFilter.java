package portaltek.cleancode.core.security.filter;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import portaltek.cleancode.core.security.JwtService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    @Qualifier(value = "jwtServiceWithoutDbCheckImpl")
    private JwtService jwtService;

    @Value("${jwt.header}")
    private String tokenHeader;
    @Value("${jwt.refresh.header}")
    private String refreshTokenHeader;

    boolean hasToken(String header) {
        return header != null && header.startsWith("Bearer ");
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain) throws ServletException, IOException {

        this.addResponseHeaders(response);

        final String header = request.getHeader(this.tokenHeader);
        if (this.hasToken(header)) {
            String token = header.substring(7);
            if (SecurityContextHolder.getContext().getAuthentication() == null) {
                this.validateToken(request, token);
            }
        }


        chain.doFilter(request, response);
    }

    private void addResponseHeaders(HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Headers",
                "Access-Control-Allow-Origin, Origin, Accept, X-Requested-With, Authorization, refreshauthorization, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, Access-Control-Allow-Credentials");
        if (response.getHeader("Access-Control-Allow-Origin") == null)
            response.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        if (response.getHeader("Access-Control-Allow-Credentials") == null)
            response.addHeader("Access-Control-Allow-Credentials", "true");
        if (response.getHeader("Access-Control-Allow-Methods") == null)
            response.addHeader("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE");
    }


    private void validateToken(HttpServletRequest request, String token) {

        //Claims claims = jwtTokenUtil.getClaimsFromToken(token);
        String username = jwtService.getUsernameFromToken(token);
        List<SimpleGrantedAuthority> authorities = jwtService.getRolesFromToken(token);
        logger.info("checking authentication for user " + username);


        if (jwtService.validateToken(token)) {

            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null, authorities);
            auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            logger.info("authenticated user " + username + ", setting security context");
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

    }


}