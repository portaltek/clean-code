package portaltek.cleancode.module.security.core.published.domain;


import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@Builder
@Accessors(fluent = true)
public class RoleDO {
    private Integer id;
    private String name;


    public static RoleDO get() {
        return builder().build();
    }

    public static RoleDO get(String name) {
        return builder()
                .name(name)
                .build();
    }
}
