package portaltek.cleancode.module.security.api.web.user;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;
import portaltek.cleancode.CleanCodeApp;
import portaltek.cleancode.itest.CleanCodeAppITestConfig;
import portaltek.cleancode.module.security.api.web.ServerResponse;
import portaltek.cleancode.module.security.api.web.token.Api;
import portaltek.cleancode.module.security.api.web.token.Header;

import static org.assertj.core.api.BDDAssertions.then;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.OK;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CleanCodeApp.class, webEnvironment = RANDOM_PORT)
@Import(CleanCodeAppITestConfig.class)
class GreetingControllerITest {

    @Autowired
    Api api;
    @Autowired
    Header header;


    String adminUrl;
    String userUrl;
    String MSG_ADMIN = "Hello Authenticated Admin";
    String MSG_USER = "Hello Authenticated User";

    @BeforeEach
    public void init() {
        adminUrl = api.url("/api/auth/admin");
        userUrl = api.url("/api/auth/user");
    }

    @Test
    public void getAdminAsAdmin_shouldReturnMsg() {

        var entity = new HttpEntity<>("", header.admin());

        var response = api.rest()
                .exchange(adminUrl, GET, entity, ServerResponse.class);

        then(response.getStatusCode()).isEqualTo(OK);
        then(response.getBody().getMessage()).isEqualTo(MSG_ADMIN);
    }

    @Test
    public void getUserAsUser_shouldReturnMsg() {

        var entity = new HttpEntity<>("", header.user());

        var response = api.rest()
                .exchange(userUrl, GET, entity, ServerResponse.class);

        then(response.getStatusCode()).isEqualTo(OK);
        then(response.getBody().getMessage()).isEqualTo(MSG_USER);
    }

    @Test
    public void getUserAsAdmin_shouldReturn200() {

        var entity = new HttpEntity<>("", header.admin());

        var response = api.rest()
                .exchange(userUrl, GET, entity, ServerResponse.class);

        then(response.getStatusCode()).isEqualTo(OK);
        then(response.getBody().getMessage()).isEqualTo(MSG_USER);

    }

    @Test
    public void getAdminAsUser_shouldReturn403() {

        var entity = new HttpEntity<>("", header.user());

        var response = api.rest()
                .exchange(adminUrl, GET, entity, ServerResponse.class);

        then(response.getStatusCode()).isEqualTo(FORBIDDEN);

    }



}




