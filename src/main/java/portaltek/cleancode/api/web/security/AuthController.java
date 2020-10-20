/**
 *
 */
package portaltek.cleancode.api.web.security;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import portaltek.cleancode.api.web.dto.ServerResponse;
import portaltek.cleancode.api.web.security.dto.JwtAuthenticationRequest;
import portaltek.cleancode.api.web.security.dto.JwtAuthenticationResponse;
import portaltek.cleancode.core.security.JwtService;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController
@RequestMapping("/api/open/")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    @Qualifier(value = "jwtServiceWithoutDbCheckImpl")
    private JwtService jwtService;

    private final Log log = LogFactory.getLog(this.getClass());

    public AuthController() {
        log.info("init AuthController");
    }




    @RequestMapping(value = "${jwt.route.auth.path}", method = {POST, OPTIONS})
    public ResponseEntity<?> createJwt(@RequestBody JwtAuthenticationRequest req)
            throws AuthenticationException {

        try {
            var auth = new UsernamePasswordAuthenticationToken(
                    req.getUsername(),
                    req.getPassword()
            );
            final var authenticated = authManager.authenticate(auth);
            SecurityContextHolder.getContext().setAuthentication(authenticated);
        } catch (AuthenticationException e) {

            return ResponseEntity
                    .status(UNAUTHORIZED)
                    .body(new ServerResponse(e.getMessage()));
        }

        final var response = jwtService.generateToken(req.getUsername());

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "ping")
    public ResponseEntity<ServerResponse> greetingUser() throws Exception {
        String msg = "Pong!";
        return ResponseEntity.ok(new ServerResponse(msg));
    }
}
