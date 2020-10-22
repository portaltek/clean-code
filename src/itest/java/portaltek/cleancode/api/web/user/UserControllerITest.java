package portaltek.cleancode.api.web.user;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import portaltek.cleancode.CleanCodeApp;
import portaltek.cleancode.api.web.Api;
import portaltek.cleancode.api.web.Token;
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

    @Autowired
    Token token;


    @Test
    public void getPing_shouldReturnPong() {
        HttpHeaders headers = token.header("admin", "admin");
        String url = api.url("/api/auth/user/ping");
        var entity = new HttpEntity<>("ping", headers);
        var response = api.rest()
                .exchange(url, GET, entity, String.class);

        then(response.getStatusCode()).isEqualTo(OK);
        then(response.getBody()).isEqualTo("Pong!");
    }


}




