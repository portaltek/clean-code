package portaltek.cleancode.module.security.api.web.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import portaltek.cleancode.module.security.domain.security.JwtService;
import portaltek.cleancode.module.security.spi.repo.model.User;
import portaltek.cleancode.module.security.domain.service.UserService;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
@RequestMapping("/api/auth/user/")
class UserController {


    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "me", method = GET)
    public ResponseEntity<String> getUserMe(
            @RequestHeader(value = "${jwt.header}") String token) {

        Long userId = jwtService.getUserIdFromToken(token.substring(6));
        User user = userService.read(userId);
        var msg = "Hello, " + user.getUsername();
        return ok(msg);
    }

    @RequestMapping(value = "ping", method = GET)
    public ResponseEntity<String> ping() {
        return ok("Pong!");
    }

}
