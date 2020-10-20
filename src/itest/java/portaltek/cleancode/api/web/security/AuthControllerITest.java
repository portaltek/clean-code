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

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.assertj.core.api.BDDAssertions.then;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CleanCodeApp.class, webEnvironment = RANDOM_PORT)
class AuthControllerITest {

    @LocalServerPort
    private int port;

    @Autowired
    private AuthController controller;
    @Autowired
    private TestRestTemplate testRestTemplate;

    final String EXPECTED_MSG = "{\"message\":\"Hello World!!!\"}";


    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
        final String url = "http://localhost:" + this.port + "/api/open/hello";
        ResponseEntity<String> entity = this.testRestTemplate
                .getForEntity(url, String.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }



}



