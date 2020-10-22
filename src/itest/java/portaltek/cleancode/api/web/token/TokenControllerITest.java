package portaltek.cleancode.api.web.token;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import portaltek.cleancode.CleanCodeApp;
import portaltek.cleancode.api.web.Api;
import portaltek.cleancode.core.security.JwtService;
import portaltek.cleancode.itest.CleanCodeAppITestConfig;

import static org.assertj.core.api.BDDAssertions.then;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.OK;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CleanCodeApp.class, webEnvironment = RANDOM_PORT)
@Import(CleanCodeAppITestConfig.class)
class TokenControllerITest {

    final String EXPECTED_MSG = "{\"message\":\"Pong!\"}";

    @Autowired
    Api api;
    HttpHeaders headers;
    String pingUrl;
    String createUrl;

    @BeforeEach
    public void init() {
        headers = api.header("admin", "admin");
        pingUrl = api.url("/api/open/token/ping");
        createUrl = api.url("/api/open/token/create");
    }
    @Autowired
    JwtService jwtService;

    @Test
    public void postValidLogin_shouldReturnToken() {

        String token = api.token("admin", "admin");
        then(token).isNotNull();

    }

    @Test
    public void getPing_shouldReturnPong() {

        var response = api.rest()
                .getForEntity(pingUrl, String.class);

        then(response.getStatusCode()).isEqualTo(OK);
        then(response.getBody()).isEqualTo(EXPECTED_MSG);
    }


}



