package mypackage


import spock.lang.Specification

class HelloTest extends Specification {


    def "load user"() {
        expect:
        name.size() == length

        where:
        name     | length
        "Spock"  | 5
        "Kirk"   | 4
        "Scotty" | 6
    }


}
