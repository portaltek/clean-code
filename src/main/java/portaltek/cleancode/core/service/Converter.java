package portaltek.cleancode.core.service;

public interface Converter<DTO, DO> {
    DTO fromDomain(DO domain);

    DO toDomain(DTO dto);
}
