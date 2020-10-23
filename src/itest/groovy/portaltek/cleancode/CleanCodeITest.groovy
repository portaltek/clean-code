package portaltek.cleancode


import portaltek.cleancode.token.spi.datastore.model.User
import spock.lang.Specification

class SimpleITest extends Specification {
    def "load from dummy class"() {
        given:
        def url = "hello";
        def user = new User("username", "password", true)
        when:
        user.username = url;

        then:
        user.username == url;
        //true == false
    }
}

class SimpleITest2 extends Specification {
    def "load from dummy class"() {
        given:
        def url = "hello";
        def user = new User("username", "password", true)
        when:
        user.username = url;

        then:
        user.username == url;
        //true == false
    }
}