package portaltek.cleancode.module.security.spi.repo

import portaltek.cleancode.module.security.domain.published.core.RoleDO
import spock.lang.Specification
import spock.lang.Subject

class RoleRepoPortImplUTest extends Specification {

    def roleRepo = new LocalRoleRepo()
    def roleConverter = new RoleConverter()
    @Subject
    def port = new RoleRepoPortImpl(roleRepo, roleConverter)

    def "save user"() {
        given:
        when:
        RoleDO role = port.read(1)
        then:
        role != null
        role.id == 1
        role.name == "ADMIN"

    }
}