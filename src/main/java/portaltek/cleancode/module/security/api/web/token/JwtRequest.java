package portaltek.cleancode.module.security.api.web.token;

import org.springframework.http.HttpEntity;

import java.io.Serializable;


class JwtRequest implements Serializable {

    private static final long serialVersionUID = -8445943548965154778L;

    private String username;
    private String password;

    public JwtRequest() {
        super();
    }

    public JwtRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static HttpEntity<JwtRequest> getEntity(String username, String password) {
        var req = new JwtRequest(username, password);
        var httpEntity = new HttpEntity<>(req);
        return httpEntity;
    }
}
