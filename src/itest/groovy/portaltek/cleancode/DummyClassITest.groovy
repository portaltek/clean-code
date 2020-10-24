package portaltek.cleancode


import spock.lang.Specification
import spock.lang.Subject

class DummyClassITest extends Specification {

    @Subject
//    DummyClass service = new DummyClass(DummyClass); // Any advantage?
    DummyClass dummy = Spy(constructorArgs: [])  //If I need to call myself.


    def "test DummyClass"() {
        given:
        def sb = new StringBuilder("0");
        when:
        dummy.myPublicLevelMethod(sb)

        then:
        //false == true
        noExceptionThrown()
        sb.toString() == "01223"
    }
}
