package portaltek.cleancode.module.security.spi.repo

import portaltek.cleancode.module.security.domain.published.core.RoleDO
import spock.lang.Specification
import spock.lang.Subject

class RoleRepoPortImplUTest extends Specification {

    @Subject
    def port = LocalRoleRepo.port()

    def "RoleRepoPortImplUTest save user"() {
        given:
        RoleDO role = RoleDO.get("ADMIN").id(1)
        port.create(role)

        when:
        RoleDO roleDO = port.read(1)

        then:
        roleDO != null
        roleDO.id() == 1
        roleDO.name() == "ADMIN"
    }
}