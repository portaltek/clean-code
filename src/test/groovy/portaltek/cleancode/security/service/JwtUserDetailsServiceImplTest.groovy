package portaltek.cleancode.security.service

import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import portaltek.cleancode.api.model.User
import portaltek.cleancode.api.repository.UserRepo
import spock.lang.Specification

class JwtUserDetailsServiceImplTest extends Specification {

    UserRepo userRepo = Mock(UserRepo)
    User user = new User("Username","Password", true)
    UserDetailsService service = new JwtUserDetailsServiceImpl(userRepo);


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
