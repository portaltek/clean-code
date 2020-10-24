package portaltek.cleancode.module.security.api.web.user;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import portaltek.cleancode.module.security.api.web.ServerResponse;


@RestController
@RequestMapping("/api/auth/")
class GreetingController {


    @RequestMapping(value = "admin", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ServerResponse> greetingAdmin() throws Exception {

        String msg = "Hello Authenticated Admin";
        return ResponseEntity.ok(new ServerResponse(msg));
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public ResponseEntity<ServerResponse> greetingUser() throws Exception {

        String msg = "Hello Authenticated User";
        return ResponseEntity.ok(new ServerResponse(msg));
    }
}