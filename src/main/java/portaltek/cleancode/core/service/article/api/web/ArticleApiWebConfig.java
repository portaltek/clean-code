package portaltek.cleancode.core.service.article.api.web;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import portaltek.cleancode.core.service.article.spi.repo.ArticleRepo;

@Configuration
class ArticleApiWebConfig {

    @Bean
    ArticleFacade articleFacade(ArticleRepo repo,
                                ArticleConverter converter) {
        return new ArticleFacade(repo, converter);
    }


}
