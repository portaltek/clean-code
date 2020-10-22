package portaltek.cleancode.core.service.article.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleRepo {
    ArticleDO findById(String id);

    Page<ArticleDO> findAll(Pageable pageable);
}
