package portaltek.cleancode.module.security.api.web.user;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;


@RestController
class UserController {

    @Value("${jwt.header}")
    private String tokenHeader;

    private UserWebPort port;

    public UserController(UserWebPort port) {
        this.port = port;
    }

    @GetMapping(value = "/api/auth/user/me")
    public ResponseEntity<String> getUserMe(
            @RequestHeader(value = "${jwt.header}") String token) {

        UserDto user = port.getUserFromToken(token);
        var msg = "Hello, " + user.username();
        return ok(msg);
    }

    @GetMapping(value = "/api/auth/user/ping")
    public ResponseEntity<String> ping() {
        return ok("Pong!");
    }

}
