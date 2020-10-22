package portaltek.cleancode.core.service.article.spi.repo;

import org.springframework.stereotype.Service;
import portaltek.cleancode.core.service.Converter;
import portaltek.cleancode.core.service.article.core.ArticleDO;

@Service
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
