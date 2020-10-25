package portaltek.cleancode.module.security.spi.repo;


import portaltek.cleancode.infra.util.Converter;
import portaltek.cleancode.module.security.domain.published.core.UserDO;

class UserConverter implements Converter<User, UserDO> {

    public UserConverter() {
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
}
