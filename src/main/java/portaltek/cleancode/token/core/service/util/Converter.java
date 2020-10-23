package portaltek.cleancode.token.core.service.util;

public interface Converter<DTO, DO> {
    DTO fromDomain(DO domain);

    DO toDomain(DTO dto);
}
