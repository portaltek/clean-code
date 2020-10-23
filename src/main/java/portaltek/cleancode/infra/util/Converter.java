package portaltek.cleancode.infra.util;

public interface Converter<DTO, DO> {
    DTO fromDomain(DO domain);

    DO toDomain(DTO dto);
}
