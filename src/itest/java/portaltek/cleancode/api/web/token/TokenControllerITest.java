package portaltek.cleancode.api.web.token;


import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import portaltek.cleancode.CleanCodeApp;
import portaltek.cleancode.api.web.token.dto.JwtRequest;
import portaltek.cleancode.api.web.token.dto.JwtResponse;

import static org.assertj.core.api.BDDAssertions.then;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.*;
import static portaltek.cleancode.api.web.token.dto.JwtRequest.getEntity;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CleanCodeApp.class, webEnvironment = RANDOM_PORT)
class TokenControllerITest {

    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate template;

    final String EXPECTED_MSG = "{\"message\":\"Pong!\"}";
    final String BASE_URL = "http://localhost:";

    private String url(String endpoint){
        return BASE_URL + this.port + "/api/open/token/" + endpoint;
    }



    @Test
    public void getPing_shouldReturnPong() {
        var url = url("ping");
        var response = template.getForEntity(url, String.class);
        then(response.getBody()).isEqualTo(EXPECTED_MSG);
        then(response.getStatusCode()).isEqualTo(OK);
    }

    @Test
    public void postValidLogin_shouldReturnToken() {
        var url = url("create");
        HttpEntity<JwtRequest> req = getEntity("admin", "admin");
        ResponseEntity<JwtResponse> response = template.postForEntity(url, req, JwtResponse.class);

        then(response.getStatusCode()).isEqualTo(OK);
        then(response.getBody().getToken()).isNotEmpty();
    }

//    @Test
//    public void postInvalidLogin_shouldReturnErrorMsg() {
//        var url = url("/api/open/login");
//        HttpEntity<JwtRequest> req = getEntity("admin", "admin2");
//        ResponseEntity<ServerResponse> response = template.postForEntity(url, req, ServerResponse.class);
//        then(response.getStatusCode()).isEqualTo(UNAUTHORIZED);
//        then(response.getBody()).isNotNull();
//    }

//
//    @Test
//    public void find_bookIdNotFound_404() throws Exception {
//
//        var expected = "{status:404,error:\"Not Found\",message:\"Book id not found : 5\",path:\"/books/5\"}";
//        var url = url("/api/open/login");
//        var httpEntity = getEntity("admin", "admin2");
//        ResponseEntity<String> response = template.exchange(url, HttpMethod.POST, httpEntity, String.class);
//
//        then(response.getStatusCode()).isEqualTo(UNAUTHORIZED);
//    }


}



