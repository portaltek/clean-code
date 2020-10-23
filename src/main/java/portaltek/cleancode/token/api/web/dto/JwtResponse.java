package portaltek.cleancode.token.api.web.dto;

import java.io.Serializable;


public class JwtResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;
    private final String refreshToken;

    public JwtResponse(String token, String refreshToken) {
        this.token = token;
        this.refreshToken = refreshToken;
    }

    public String getToken() {
        return this.token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
