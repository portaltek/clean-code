package portaltek.cleancode.api.security.service

import spock.lang.Specification

class JwtUserDetailsServiceImplTest extends Specification {
    def "load existing user by username"() {
        when:
        String hello = "hello"
        then:
        hello == "hello"

    }
}
