package portaltek.cleancode.core.service.article.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ArticleCoreConfig {

    @Bean
    ArticleService articleService(ArticleRepoFacade repoFacade) {
        return new ArticleServiceImpl(repoFacade);
    }
}
