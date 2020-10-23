package portaltek.cleancode.article.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleRepoFacade {

    ArticleDO findByTitle(String title);

    Page<ArticleDO> findAll(Pageable pageable);
}
