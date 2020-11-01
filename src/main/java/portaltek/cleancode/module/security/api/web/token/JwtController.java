package portaltek.cleancode.module.security.api.web.token;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import portaltek.cleancode.infra.web.Credentials;
import portaltek.cleancode.infra.web.ServerResponse;
import portaltek.cleancode.module.security.core.published.service.JwtGenerator;


import static org.springframework.http.ResponseEntity.ok;


@RestController
class JwtController {

    private final Log log = LogFactory.getLog(this.getClass());

    private AuthenticationManager authManager;
    private JwtGenerator jwtGenerator;

    public JwtController(AuthenticationManager authManager,
                         JwtGenerator jwtGenerator) {
        this.authManager = authManager;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping(value = "/api/open/token/${jwt.route.open.token.create}")
    public ResponseEntity<?> createJwt(@RequestBody JwtRequest req)
            throws AuthenticationException {

        try {
            var credentials = Credentials
                    .of(req.getUsername(), req.getPassword());
            final var auth = authManager.authenticate(credentials);
            SecurityContextHolder.getContext().setAuthentication(auth);

        } catch (AuthenticationException e) {
            return ServerResponse.of(e);
        }

        var response = jwtGenerator.create(req.getUsername());
        return ok(response);
    }

    @GetMapping(value = "/api/open/token/ping")
    public ResponseEntity<ServerResponse> ping() {
        return ok(ServerResponse.of("Pong!"));
    }
}
