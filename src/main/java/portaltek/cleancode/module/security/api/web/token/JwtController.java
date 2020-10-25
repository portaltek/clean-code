/**
 *
 */
package portaltek.cleancode.module.security.api.web.token;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import portaltek.cleancode.infra.web.ServerResponse;
import portaltek.cleancode.module.security.domain.published.service.JwtService;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.ResponseEntity.ok;


@RestController
class JwtController {

    private final Log log = LogFactory.getLog(this.getClass());

    private AuthenticationManager authManager;
    private JwtService jwtService;

    public JwtController(AuthenticationManager authManager,
                         JwtService jwtService) {
        this.authManager = authManager;
        this.jwtService = jwtService;
    }

    @PostMapping(value = "/api/open/token/${jwt.route.open.token.create}")
    public ResponseEntity<?> createJwt(@RequestBody JwtRequest req)
            throws AuthenticationException {

        try {
            var credentials = new UsernamePasswordAuthenticationToken(
                    req.getUsername(),
                    req.getPassword()
            );
            final var auth = authManager.authenticate(credentials);
            SecurityContextHolder.getContext().setAuthentication(auth);

        } catch (AuthenticationException e) {
            return ResponseEntity
                    .status(UNAUTHORIZED)
                    .body(new ServerResponse(e.getMessage()));
        }

        var response = jwtService.generateToken(req.getUsername());
        return ok(response);
    }

    @GetMapping(value = "/api/open/token/ping")
    public ResponseEntity<ServerResponse> ping() throws Exception {
        return ok(new ServerResponse("Pong!"));
    }
}
