package portaltek.cleancode.api.web.jwt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import portaltek.cleancode.api.web.jwt.model.User;
import portaltek.cleancode.api.web.jwt.security.service.JwtUtil;
import portaltek.cleancode.api.web.jwt.service.IUserService;


@RestController
@RequestMapping("/api/auth/")
public class AuthenticatedUserController {


    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    @Qualifier(value = "jwtUtilWithoutDbCheckImpl")
    private JwtUtil jwtTokenUtil;
    @Autowired
    private IUserService userService;

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
