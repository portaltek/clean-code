package portaltek.cleancode.itest;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import portaltek.cleancode.api.web.Api;
import portaltek.cleancode.api.web.Token;

@Lazy
@TestConfiguration
public class CleanCodeAppITestConfig {

    @LocalServerPort
    int port;
    final String host = "http://localhost:";
    final String tokenEndpoint = "/api/open/token/create";

    @Bean
    public Api api(TestRestTemplate rest){
        return new Api(rest, host, port);
    }
    @Bean
    public Token token(Api api){
        return new Token(api, tokenEndpoint);
    }

}

