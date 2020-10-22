package portaltek.cleancode.api.web;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import portaltek.cleancode.api.web.token.dto.JwtRequest;
import portaltek.cleancode.api.web.token.dto.JwtResponse;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static portaltek.cleancode.api.web.token.dto.JwtRequest.getEntity;


public class Token {

    final private Api api;
    final private String tokenEndpoint;

    public Token(Api api, String tokenEndpoint) {
        this.api = api;
        this.tokenEndpoint = tokenEndpoint;
    }

    public String get(String username, String password) {
        var url = api.urlBase() + tokenEndpoint;
        HttpEntity<JwtRequest> req = getEntity(username, password);
        return api.rest().postForEntity(url, req, JwtResponse.class)
                .getBody()
                .getToken();
    }

    public HttpHeaders header(String username, String password) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, "Bearer " + get(username,password));
        return headers;
    }


}




