package portaltek.cleancode.api.web.jwt.security.filter;


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
import portaltek.cleancode.api.web.jwt.security.service.JwtUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    @Qualifier(value = "jwtUtilWithoutDbCheckImpl")
    private JwtUtil jwtTokenUtil;

    @Value("${jwt.header}")
    private String tokenHeader;
    @Value("${jwt.refresh.header}")
    private String refreshTokenHeader;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        response.addHeader("Access-Control-Allow-Headers",
                "Access-Control-Allow-Origin, Origin, Accept, X-Requested-With, Authorization, refreshauthorization, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, Access-Control-Allow-Credentials");
        if (response.getHeader("Access-Control-Allow-Origin") == null)
            response.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        if (response.getHeader("Access-Control-Allow-Credentials") == null)
            response.addHeader("Access-Control-Allow-Credentials", "true");
        if (response.getHeader("Access-Control-Allow-Methods") == null)
            response.addHeader("Access-Control-Allow-Methods", "OPTIONS, GET, POST, PUT, DELETE");

        String token;

        if (!request.getMethod().equals("OPTIONS")) {
            token = request.getHeader(this.tokenHeader).substring(6);
        } else {
            token = request.getHeader(this.tokenHeader);
        }

        if (token != null && !token.equals("")) {

            if (jwtTokenUtil.isTokenExpired(token)) {
                response.setStatus(490);
                return;
            }

            if (jwtTokenUtil.validateToken(token)) {

                String username = jwtTokenUtil.getUsernameFromToken(token);
                List<SimpleGrantedAuthority> authorities = jwtTokenUtil.getRolesFromToken(token);
                logger.info("checking authentication for user " + username);

                if (SecurityContextHolder.getContext().getAuthentication() == null) {

                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null, authorities);
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    logger.info("authenticated user " + username + ", setting security context");
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        chain.doFilter(request, response);

    }

}