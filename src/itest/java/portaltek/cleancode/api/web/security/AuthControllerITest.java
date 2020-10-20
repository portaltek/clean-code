/**
 *
 */
package portaltek.cleancode.api.web.security;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import portaltek.cleancode.CleanCodeApp;
import portaltek.cleancode.api.web.security.dto.JwtAuthenticationRequest;
import portaltek.cleancode.api.web.security.dto.JwtAuthenticationResponse;

import static org.assertj.core.api.BDDAssertions.then;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CleanCodeApp.class, webEnvironment = RANDOM_PORT)
class AuthControllerITest {

    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate template;

    final String EXPECTED_MSG = "{\"message\":\"Hello World!!!\"}";
    final String BASE_URL = "http://localhost:";

    String url(String endpoint){
        return BASE_URL + this.port + endpoint;
    }

    @Test
    public void helloShouldReturnHelloWorld() {
        var url = url("/api/open/hello");
        var entity = template.getForEntity(url, String.class);
        then(entity.getBody()).isEqualTo(EXPECTED_MSG);
        then(entity.getStatusCode()).isEqualTo(OK);
    }

    @Test
    public void postValidLoginShouldReturnToken() {
        var url = url("/api/open/login");
        var req = new JwtAuthenticationRequest("admin", "admin");
        var request = new HttpEntity<>(req);
        var entity = template
                .postForEntity(url, request, JwtAuthenticationResponse.class);

        then(entity.getStatusCode()).isEqualTo(OK);
        then(entity.getBody().getToken()).isNotEmpty();
    }




}



