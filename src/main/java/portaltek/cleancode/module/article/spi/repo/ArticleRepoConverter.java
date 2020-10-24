package portaltek.cleancode.module.article.spi.repo;

import portaltek.cleancode.infra.util.Converter;
import portaltek.cleancode.module.article.core.ArticleDO;

class ArticleRepoConverter implements Converter<Article, ArticleDO> {

    @Override
    public Article fromDomain(ArticleDO domain) {
        return Article.builder()
                .title(domain.title())
                .published(domain.published())
                .body(domain.body())
                .author(domain.author())
                .build();
    }

    @Override
    public ArticleDO toDomain(Article dto) {
        return ArticleDO.builder()
                .title(dto.title())
                .published(dto.published())
                .body(dto.body())
                .author(dto.author())
                .build();
    }
}
