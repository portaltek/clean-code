package portaltek.cleancode.module.security.domain.published.core;

public class RoleDOBuilder {
    public static RoleDO get(String name) {
        return RoleDO.builder()
                .name(name)
                .build();
    }
}
