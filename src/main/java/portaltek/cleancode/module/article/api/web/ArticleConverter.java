package portaltek.cleancode.module.article.api.web;


import org.springframework.stereotype.Service;
import portaltek.cleancode.module.article.core.ArticleDO;
import portaltek.cleancode.infra.util.Converter;
import portaltek.cleancode.module.security.domain.published.core.RoleDO;


@Service
class ArticleConverter implements Converter<ArticleDto, ArticleDO> {

    @Override
    public ArticleDto fromDomain(ArticleDO domain) {
        return ArticleDto.builder()
                .title(domain.title())
                .published(domain.published())
                .body(domain.body())
                .author(domain.author())
                .build();
    }

    @Override
    public ArticleDO toDomain(ArticleDto dto) {
        return ArticleDO.builder()
                .title(dto.title())
                .published(dto.published())
                .body(dto.body())
                .author(dto.author())
                .build();
    }

    @Override
    public ArticleDO toDomain(ArticleDO domain, ArticleDto articleDto) {
        return null;
    }
}
