package portaltek.cleancode.itest;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import portaltek.cleancode.module.security.api.web.token.Api;

@Lazy
@TestConfiguration
public class CleanCodeAppITestConfig {

    @LocalServerPort
    int port;
    String host = "http://localhost:";
    String tokenEndpoint = "/api/open/token/create";

    @Bean
    public Rest rest(TestRestTemplate rest){
        return new Rest(rest, host, port);
    }
    @Bean
    public Api api(Rest rest){
        return new Api(rest, tokenEndpoint);
    }

}

