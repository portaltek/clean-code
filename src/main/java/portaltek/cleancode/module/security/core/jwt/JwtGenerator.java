package portaltek.cleancode.module.security.core.jwt;

import portaltek.cleancode.module.security.api.web.token.JwtResponse;

import java.io.Serializable;

interface JwtGenerator extends Serializable {
    JwtResponse create(String username);

    JwtResponse refresh(String username);
}
