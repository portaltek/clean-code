/**
 *
 */
package portaltek.cleancode.api.web.security;


import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = RANDOM_PORT)
@SpringBootTest
class AuthControllerITest {

//    @LocalServerPort
//    private int port;

    @Autowired
    private AuthController controller;
//    @Autowired
//    private TestRestTemplate restTemplate;

    //String URL = "http://localhost:" + port + "/api/open/hello/";
    String URL = "http://localhost:8080/api/open/hello/";
    String EXPECTED_MSG = "{\"message\":\"Hello World!!!\"}";


    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

//    @Test
//    public void greetingShouldReturnDefaultMessage() {
//        assertThat(restTemplate.getForObject(URL, String.class))
//                .contains(EXPECTED_MSG);
//    }

}



