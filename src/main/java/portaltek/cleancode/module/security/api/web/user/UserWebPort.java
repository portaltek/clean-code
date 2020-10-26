package portaltek.cleancode.module.security.api.web.user;


import portaltek.cleancode.module.security.core.published.domain.UserDO;
import portaltek.cleancode.module.security.core.published.service.JwtService;
import portaltek.cleancode.module.security.core.published.service.UserService;

class UserWebPort {

    private JwtService jwtService;
    private UserService userService;
    private UserDtoConverter userDTOConverter;

    public UserWebPort(JwtService jwtService, UserService userService, UserDtoConverter userDTOConverter) {
        this.jwtService = jwtService;
        this.userService = userService;
        this.userDTOConverter = userDTOConverter;
    }

    public UserDto getUserFromToken(String token) {
        Long userId = jwtService.getUserIdFromToken(token.substring(6));
        UserDO userDO = userService.read(userId);
        return userDTOConverter.fromDomain(userDO);
    }
}
