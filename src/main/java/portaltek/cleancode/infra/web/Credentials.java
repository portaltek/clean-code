package portaltek.cleancode.infra.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


public class Credentials extends UsernamePasswordAuthenticationToken {
    private final Log log = LogFactory.getLog(this.getClass());

    public Credentials(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public static Credentials of(Object principal, Object credentials) {
        return new Credentials(principal, credentials);
    }

}
