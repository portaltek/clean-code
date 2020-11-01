package portaltek.cleancode.module.security.core.published.service;

import portaltek.cleancode.module.security.api.web.token.JwtResponse;

import java.io.Serializable;

public interface JwtGenerator extends Serializable {
    JwtResponse create(String username);

    JwtResponse refresh(String username);
}
