package portaltek.cleancode.article.api.web;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import portaltek.cleancode.article.core.ArticleService;

@Configuration
class ArticleWebConfig {

    @Bean
    public ArticleWebFacade articleWebFacade(ArticleService service,
                                   ArticleConverter converter) {
        return new ArticleWebFacade(service, converter);
    }


}
