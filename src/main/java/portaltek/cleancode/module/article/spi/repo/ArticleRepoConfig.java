package portaltek.cleancode.module.article.spi.repo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import portaltek.cleancode.module.article.core.ArticleRepoFacade;

@Configuration
class ArticleRepoConfig {

    @Bean
    ArticleRepo articleRepo() {
        return new ArticleRepoInMemory();
    }

    @Bean
    ArticleRepoConverter articleRepoConverter() {
        return new ArticleRepoConverter();
    }

    @Bean
    ArticleRepoFacade articleRepoFacade(ArticleRepo repo,
                                        ArticleRepoConverter converter) {
        return new ArticleRepoFacadeImpl(repo, converter);
    }



}

