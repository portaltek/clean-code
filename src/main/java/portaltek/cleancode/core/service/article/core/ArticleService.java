package portaltek.cleancode.core.service.article.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleService {

    ArticleDO findByTitle(String title);

    Page<ArticleDO> findAll(Pageable pageable);
}
