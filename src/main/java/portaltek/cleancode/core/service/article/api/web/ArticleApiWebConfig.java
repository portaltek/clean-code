package portaltek.cleancode.core.service.article.api.web;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import portaltek.cleancode.core.service.article.core.ArticleService;

@Configuration
class ArticleApiWebConfig {

    @Bean
    ArticleFacade articleFacade(ArticleService service,
                                ArticleConverter converter) {
        return new ArticleFacade(service, converter);
    }


}
