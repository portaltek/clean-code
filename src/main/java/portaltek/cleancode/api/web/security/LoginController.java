/**
 *
 */
package portaltek.cleancode.api.web.security;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import portaltek.cleancode.api.web.dto.ServerResponse;
import portaltek.cleancode.api.web.security.dto.JwtRequest;
import portaltek.cleancode.core.security.JwtService;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController
@RequestMapping("/api/open/login")
public class LoginController {

    private final Log log = LogFactory.getLog(this.getClass());

    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JwtService jwtService;

    public LoginController() {
        log.info("init AuthController");
    }




    @RequestMapping(value = "${jwt.route.open.login.token}", method = {POST, OPTIONS})
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

    @GetMapping(value = "ping")
    public ResponseEntity<ServerResponse> greetingUser() throws Exception {
        return ok(new ServerResponse("Pong!"));
    }
}
