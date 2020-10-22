package portaltek.cleancode.api.web;


import org.springframework.boot.test.web.client.TestRestTemplate;


public class Api {

    final private Integer port;
    final private String host;
    final private String urlBase;
    final private TestRestTemplate rest;


    public Api(TestRestTemplate rest, String host, Integer port) {
        this.rest = rest;
        this.port = port;
        this.host = host;
        this.urlBase = host + port;
    }

    public Integer getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String url(String endpoint) {
        return urlBase + endpoint;
    }

    public String urlBase() {
        return urlBase;
    }

    public TestRestTemplate rest() {
        return rest;
    }


}




