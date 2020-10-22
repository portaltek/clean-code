package portaltek.cleancode.core.service.article.api.web;


import org.springframework.stereotype.Service;
import portaltek.cleancode.core.service.article.domain.ArticleDO;

@Service
class ArticleConverter {

    ArticleDto convert(ArticleDO source) {
        return ArticleDto.builder()
                .title(source.title())
                .published(source.published())
                .body(source.body())
                .author(source.author())
                .build();
    }

}
