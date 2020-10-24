package portaltek.cleancode.module.security.api.web.token;


import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import portaltek.cleancode.itest.Rest;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static portaltek.cleancode.module.security.api.web.token.JwtRequest.getEntity;


public class Api {

    final private Rest rest;
    final private String tokenEndpoint;

    public Api(Rest rest, String tokenEndpoint) {
        this.rest = rest;
        this.tokenEndpoint = tokenEndpoint;
    }

    public String token(String username, String password) {
        var url = rest.urlBase() + tokenEndpoint;
        HttpEntity<JwtRequest> req = getEntity(username, password);
        return rest.template().postForEntity(url, req, JwtResponse.class)
                .getBody()
                .getToken();
    }

    public HttpHeaders header(String username, String password) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + token(username,password));
        return headers;
    }

    public TestRestTemplate rest(){
        return rest.template();
    }

    public String url(String endpoint){
        return rest.url(endpoint);
    }

}




