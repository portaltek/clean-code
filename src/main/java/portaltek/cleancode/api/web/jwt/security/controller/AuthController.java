/**
 *
 */
package portaltek.cleancode.api.web.jwt.security.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import portaltek.cleancode.api.web.jwt.controller.dto.ServerResponse;
import portaltek.cleancode.api.web.jwt.security.controller.dto.JwtAuthenticationRequest;
import portaltek.cleancode.api.web.jwt.security.controller.dto.JwtAuthenticationResponse;
import portaltek.cleancode.api.web.jwt.security.service.JwtUtil;


@RestController
@RequestMapping("/api/open/")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    @Qualifier(value = "jwtUtilWithoutDbCheckImpl")
    private JwtUtil jwtTokenUtil;

    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.OPTIONS})
    public ResponseEntity<String> getAuthenticatedUser() {
        return ResponseEntity.ok("Hello!!!");
    }
    @RequestMapping(value = "${jwt.route.authentication.path}", method = {RequestMethod.POST, RequestMethod.OPTIONS})
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {

        // Perform the security
        try {
            final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUsername(),
                            authenticationRequest.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (AuthenticationException e) {

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ServerResponse(e.getMessage()));
        }

        final JwtAuthenticationResponse token = jwtTokenUtil.generateToken(authenticationRequest.getUsername());
        jwtTokenUtil.generateToken(authenticationRequest.getUsername());

        // Return the token
        return ResponseEntity.ok(token);
    }
}
