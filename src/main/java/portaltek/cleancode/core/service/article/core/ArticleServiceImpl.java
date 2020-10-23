package portaltek.cleancode.core.service.article.core;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
class ArticleServiceImpl implements ArticleService {

    ArticleRepoFacade repoFacade;

    public ArticleDO findByTitle(String title){
        return repoFacade.findByTitle(title);
    }

    public Page<ArticleDO> findAll(Pageable pageable){
        return repoFacade.findAll(pageable);
    }
}
