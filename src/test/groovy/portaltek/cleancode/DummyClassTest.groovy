package portaltek.cleancode


import portaltek.cleancode.spi.datastore.model.User
import portaltek.cleancode.spi.datastore.repository.UserRepo
import spock.lang.Specification
import spock.lang.Subject

class DummyClassTest extends Specification {

    UserRepo userRepo = Mock()
    User user = new User("Username","Password", true)

    @Subject
    //DummyClass service = new DummyClass(userRepo); // Any advantage?
    DummyClass service = Spy(constructorArgs: [userRepo])  //If I need to call myself.

    def "load from dummy class"() {
        given:
        userRepo.findByUsername("Username") >> user


        when:
        service.myPublicLevelMethod("Username")

        then:
        noExceptionThrown()
        1 * service.myPackageLevelMethod({
            it.username == "Username2"
            it.password == "Password"
        }, _)
        1 * service.myPackageLevelMethod(_ as User, _)
        1 * userRepo.save({it.username == "Username233"})
    }

    def "load from dummy class2"() {
        given:
        when:
        service.myPackageLevelMethod(user, user)

        then:
        //false == true
        noExceptionThrown()
        user.username == "Username3"

    }
}
