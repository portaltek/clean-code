/**
 *
 */
package portaltek.cleancode.api.web.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import portaltek.cleancode.api.web.dto.ServerResponse;
import portaltek.cleancode.api.web.security.dto.JwtAuthenticationRequest;
import portaltek.cleancode.api.web.security.dto.JwtAuthenticationResponse;
import portaltek.cleancode.core.security.JwtService;

import static org.springframework.http.HttpStatus.*;


@RestController
@RequestMapping("/api/open/")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    @Qualifier(value = "jwtServiceWithoutDbCheckImpl")
    private JwtService jwtService;


    @RequestMapping(value = "${jwt.route.authentication.path}", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public ResponseEntity<?> createJwt(@RequestBody JwtAuthenticationRequest req)
            throws AuthenticationException {

        try {
            Authentication auth = new UsernamePasswordAuthenticationToken(
                    req.getUsername(),
                    req.getPassword()
            );
            final Authentication authenticated = authenticationManager.authenticate(auth);
            SecurityContextHolder.getContext().setAuthentication(authenticated);
        } catch (AuthenticationException e) {

            return ResponseEntity
                    .status(UNAUTHORIZED)
                    .body(new ServerResponse(e.getMessage()));
        }

        final JwtAuthenticationResponse response = jwtService.generateToken(req.getUsername());

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "hello")
    public ResponseEntity<ServerResponse> greetingUser() throws Exception {

        String msg = "Hello World!!!";
        return ResponseEntity.ok(new ServerResponse(msg));
    }
}
