package portaltek.cleancode.api.web.user;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import portaltek.cleancode.CleanCodeApp;
import portaltek.cleancode.api.web.token.dto.JwtRequest;
import portaltek.cleancode.api.web.token.dto.JwtResponse;

import static org.assertj.core.api.BDDAssertions.then;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.http.HttpStatus.OK;
import static portaltek.cleancode.api.web.token.dto.JwtRequest.getEntity;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CleanCodeApp.class, webEnvironment = RANDOM_PORT)
class UserControllerITest {

    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate rest;

    final String HOST = "http://localhost:";
    final String ENDPOINT = "/api/auth/user/";

    private String url(String suffix) {
        return HOST + port + ENDPOINT + suffix;
    }

    private String getToken() {
        var url = HOST + port + "/api/open/token/create";
        HttpEntity<JwtRequest> req = getEntity("admin", "admin");
        return rest.postForEntity(url, req, JwtResponse.class)
                .getBody()
                .getToken();
    }

    private HttpHeaders getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + getToken());
        return headers;
    }


    @Test
    public void getPing_shouldReturnPong() {
        var entity = new HttpEntity<>("ping", getHeader());
        var response = rest.exchange(url("ping"), GET, entity, String.class);
        then(response.getStatusCode()).isEqualTo(OK);
        then(response.getBody()).isEqualTo("Pong!");
    }


}




