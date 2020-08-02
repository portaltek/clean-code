/**
 *
 */
package portaltek.cleancode.api.security.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import portaltek.cleancode.api.controller.dto.ServerResponse;
import portaltek.cleancode.api.security.controller.dto.JwtAuthenticationRequest;
import portaltek.cleancode.api.security.controller.dto.JwtAuthenticationResponse;
import portaltek.cleancode.api.security.service.JwtUtil;

import static org.springframework.http.HttpStatus.*;


@RestController
@RequestMapping("/api/open/")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    @Qualifier(value = "jwtUtilWithoutDbCheckImpl")
    private JwtUtil jwtUtil;
    @RequestMapping(value = "${jwt.route.authentication.path}", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public ResponseEntity<?> createJwt(@RequestBody JwtAuthenticationRequest req)
            throws AuthenticationException {

        try {
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    req.getUsername(),
                    req.getPassword()
            );
            final Authentication authenticated = authenticationManager.authenticate(authentication);
            SecurityContextHolder.getContext().setAuthentication(authenticated);
        } catch (AuthenticationException e) {

            return ResponseEntity
                    .status(UNAUTHORIZED)
                    .body(new ServerResponse(e.getMessage()));
        }

        final JwtAuthenticationResponse token = jwtUtil.generateToken(req.getUsername());
        jwtUtil.generateToken(req.getUsername());

        // Return the token
        return ResponseEntity.ok(token);
    }

    @GetMapping(value = "hello")
    public ResponseEntity<ServerResponse> greetingUser() throws Exception {

        String msg = "Hello World!!!";
        return ResponseEntity.ok(new ServerResponse(msg));
    }
}
