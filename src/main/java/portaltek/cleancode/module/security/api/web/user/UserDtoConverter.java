package portaltek.cleancode.module.security.api.web.user;


import portaltek.cleancode.infra.util.Converter;
import portaltek.cleancode.module.security.core.published.domain.UserDO;

class UserDtoConverter implements Converter<UserDto, UserDO> {

    public UserDtoConverter() {
    }

    @Override
    public UserDto fromDomain(UserDO domain) {
        return UserDto.builder()
                .id(domain.id())
                .username(domain.username())
                .enabled(domain.enabled())
                .build();
    }

    @Override
    public UserDO toDomain(UserDto dto) {
        return toDomain(UserDO.builder().build(), dto);
    }

    @Override
    public UserDO toDomain(UserDO domain, UserDto dto) {
        return domain
                .id(dto.id())
                .username(dto.username())
                .enabled(dto.enabled());
    }


}
