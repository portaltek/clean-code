package portaltek.cleancode.module.security.api.web.user;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import portaltek.cleancode.CleanCodeApp;
import portaltek.cleancode.module.security.api.web.token.Api;
import portaltek.cleancode.itest.CleanCodeAppITestConfig;

import static org.assertj.core.api.BDDAssertions.then;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CleanCodeApp.class, webEnvironment = RANDOM_PORT)
@Import(CleanCodeAppITestConfig.class)
class UserControllerITest {

    @Autowired
    Api api;
    HttpHeaders headers;
    String pingUrl;

    @BeforeEach
    public void init() {
        headers = api.header("admin", "admin");
        pingUrl = api.url("/api/auth/user/ping");
    }

    @Test
    public void getPing_shouldReturnPong() {

        var entity = new HttpEntity<>("", headers);

        var response = api.rest()
                .exchange(pingUrl, GET, entity, String.class);

        then(response.getStatusCode()).isEqualTo(OK);
        then(response.getBody()).isEqualTo("Pong!");
    }

    @Test
    public void givenBadToken_getPing_shouldReturn401() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer 123456");
        var entity = new HttpEntity<>("", headers);

        var response = api.rest()
                .exchange(pingUrl, GET, entity, String.class);

        then(response.getStatusCode()).isEqualTo(UNAUTHORIZED);
    }



}




