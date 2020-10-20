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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import portaltek.cleancode.CleanCodeApp;

import static org.assertj.core.api.BDDAssertions.then;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CleanCodeApp.class, webEnvironment = RANDOM_PORT)
class AuthControllerITest {

    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate template;

    final String EXPECTED_MSG = "{\"message\":\"Hello World!!!\"}";

    @Test
    public void helloShouldReturnHelloWorld() {
        String url = "http://localhost:" + this.port + "/api/open/hello";
        ResponseEntity<String> entity = template.getForEntity(url, String.class);

        then(entity.getBody()).isEqualTo(EXPECTED_MSG);
        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }



}



