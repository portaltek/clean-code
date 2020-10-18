package portaltek.cleancode.api.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import portaltek.cleancode.core.security.JwtService;
import portaltek.cleancode.spi.datastore.model.User;
import portaltek.cleancode.core.service.UserService;


@RestController
@RequestMapping("/api/auth/")
public class AuthenticatedUserController {


    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    @Qualifier(value = "jwtServiceWithoutDbCheckImpl")
    private JwtService jwtTokenUtil;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "me", method = RequestMethod.GET)
    public ResponseEntity<String> getAuthenticatedUser(
            @RequestHeader(value = "${jwt.header}") String token) {

        Long userId = jwtTokenUtil.getUserIdFromToken(token.substring(6));
        User user = userService.read(userId);
        return ResponseEntity.ok(user.getUsername());
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public ResponseEntity<String> getAuthenticatedUser() {
        return ResponseEntity.ok("Hello!!!");
    }

}
