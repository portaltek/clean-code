package portaltek.cleancode.core.service.article.api.web;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import portaltek.cleancode.core.service.article.domain.ArticleRepo;

@Configuration
class ArticleApiWebConfig {

    @Bean
    ArticleConverter articleConverter() {
        return new ArticleConverter();
    }

    @Bean
    ArticleFacade articleFacade(ArticleRepo repo,
                                ArticleConverter converter) {
        return new ArticleFacade(repo, converter);
    }


}
