package portaltek.cleancode.core.service.article.spi.repo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import portaltek.cleancode.core.service.article.core.ArticleRepoFacade;


class ArticleRepoConfig {

//    @Bean
    ArticleRepoFacade articleRepoFacade(ArticleRepo repo,
                                        ArticleRepoConverter converter) {
        return new ArticleRepoFacadeImpl(repo, converter);
    }

}

