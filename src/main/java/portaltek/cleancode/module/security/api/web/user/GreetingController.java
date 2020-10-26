package portaltek.cleancode.module.security.api.web.user;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import portaltek.cleancode.infra.web.ServerResponse;


@RestController
class GreetingController {


    @GetMapping(value = "/api/auth/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<ServerResponse> greetingAdmin() {

        String msg = "Hello Authenticated Admin";
        return ResponseEntity.ok(new ServerResponse(msg));
    }

    @GetMapping(value = "/api/auth/user")
    public ResponseEntity<ServerResponse> greetingUser() {

        String msg = "Hello Authenticated User";
        return ResponseEntity.ok(new ServerResponse(msg));
    }
}