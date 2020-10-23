package portaltek.cleancode.article.spi.repo;

import portaltek.cleancode.token.core.service.util.Converter;
import portaltek.cleancode.article.core.ArticleDO;

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
