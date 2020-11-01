package portaltek.cleancode.module.security.api.web.user;


import portaltek.cleancode.module.security.core.jwt.JwtUtil;
import portaltek.cleancode.module.security.core.published.domain.UserDO;
import portaltek.cleancode.module.security.core.published.service.UserService;

class UserWebPort {

    private JwtUtil jwt;
    private UserService userService;
    private UserDtoConverter userDTOConverter;

    public UserWebPort(JwtUtil jwt, UserService userService, UserDtoConverter userDTOConverter) {
        this.jwt = jwt;
        this.userService = userService;
        this.userDTOConverter = userDTOConverter;
    }

    public UserDto getUserFromToken(String token) {
        Long userId = jwt.getUserIdFromToken(token);
        UserDO userDO = userService.read(userId);
        return userDTOConverter.fromDomain(userDO);
    }
}
