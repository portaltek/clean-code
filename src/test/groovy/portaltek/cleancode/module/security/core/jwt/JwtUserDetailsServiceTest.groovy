package portaltek.cleancode.module.security.core.jwt

import org.springframework.security.core.userdetails.UsernameNotFoundException
import portaltek.cleancode.module.security.core.published.domain.UserDO
import portaltek.cleancode.module.security.spi.repo.UserRepoPortImpl
import spock.lang.Specification
import spock.lang.Subject

class JwtUserDetailsServiceTest extends Specification {

    def port = Mock(UserRepoPortImpl)
    def userDO = UserDO.get("Username")
    @Subject
    def service = new JwtUserDetailsService(port)


    def "load existing user by username returns UserDetails"() {
        given:
        port.findUserByUsername("Username") >> userDO

        when:
        def userFound = service.loadUserByUsername("Username")

        then:
        userFound != null
        userFound.username == 'Username'
    }

    def "load non-existing user by username throws UsernameNotFoundException"() {
        given:

        when:
        service.loadUserByUsername("Username")

        then:
        UsernameNotFoundException ex = thrown()
        ex.message == "No user found with username 'Username'."
    }

}
