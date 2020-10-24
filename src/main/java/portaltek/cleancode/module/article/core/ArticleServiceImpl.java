package portaltek.cleancode.module.article.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


class ArticleServiceImpl implements ArticleService {

    ArticleRepoFacade repoFacade;

    public ArticleServiceImpl(ArticleRepoFacade repoFacade) {
        this.repoFacade = repoFacade;
    }

    public ArticleDO findByTitle(String title){
        return repoFacade.findByTitle(title);
    }

    public Page<ArticleDO> findAll(Pageable pageable){
        return repoFacade.findAll(pageable);
    }
}
