package portaltek.cleancode.module.security.spi.repo;


import portaltek.cleancode.infra.util.Converter;
import portaltek.cleancode.module.security.domain.published.core.RoleDO;
import portaltek.cleancode.module.security.domain.published.core.UserDO;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

class UserConverter implements Converter<User, UserDO> {

    private RoleConverter roleConverter;

    public UserConverter(RoleConverter roleConverter) {
        this.roleConverter = roleConverter;
    }

    @Override
    public User fromDomain(UserDO domain) {
        User user = new User(domain.username(),
                domain.password(),
                domain.enabled());
        user.setEnabled(domain.enabled());
        user.setRoles(domain.roles());
        return user;
    }

    @Override
    public UserDO toDomain(User dto) {
        return UserDO.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .enabled(dto.isEnabled())
                .roles(dto.getRoles())
                .build();
    }

    public Set<RoleDO> getRoles(User dto) {
        return dto.getRoles().stream()
                .map(roleConverter::toDomain)
                .collect(toSet());
    }

//    public Set<Role> getRoles(UserDO domain) {
//        return domain.roles().stream()
//                .map(e -> roleConverter.fromDomain(e))
//                .collect(toSet());
//    }
}
