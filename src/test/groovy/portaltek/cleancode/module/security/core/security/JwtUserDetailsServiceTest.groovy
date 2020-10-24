package portaltek.cleancode.module.security.core.security

import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import portaltek.cleancode.module.security.spi.datastore.model.User
import spock.lang.Specification

class JwtUserDetailsServiceTest extends Specification {

    def userRepo = Mock(portaltek.cleancode.module.security.spi.datastore.repository.UserRepo)
    User user = new User("Username","Password", true)
    UserDetailsService service = new JwtUserDetailsService(userRepo);


    def "load existing user by username returns UserDetails"() {
        given:
        userRepo.findByUsername("Username") >> user

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
