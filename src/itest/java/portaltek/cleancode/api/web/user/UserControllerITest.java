package portaltek.cleancode.api.web.user;


import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import portaltek.cleancode.CleanCodeApp;
import portaltek.cleancode.api.web.Api;
import portaltek.cleancode.itest.CleanCodeAppITestConfig;

import static org.assertj.core.api.BDDAssertions.then;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpStatus.OK;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CleanCodeApp.class, webEnvironment = RANDOM_PORT)
@Import(CleanCodeAppITestConfig.class)
class UserControllerITest {

    @Autowired
    Api api;
    String hello;
    HttpHeaders headers;
    String pingUrl;

    @BeforeEach
    public void init() {
        headers = api.header("admin", "admin");
        pingUrl = api.url("/api/auth/user/ping");
    }

    @Test
    public void getPing_shouldReturnPong() {

        var entity = new HttpEntity<>("ping", headers);
        var response = api.rest()
                .exchange(pingUrl, GET, entity, String.class);

        then(response.getStatusCode()).isEqualTo(OK);
        then(response.getBody()).isEqualTo("Pong!");
    }


}




