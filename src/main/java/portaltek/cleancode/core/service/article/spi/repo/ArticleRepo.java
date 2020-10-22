package portaltek.cleancode.core.service.article.spi.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import portaltek.cleancode.core.service.article.core.ArticleDO;

public interface ArticleRepo {
    ArticleDO findById(String id);

    Page<ArticleDO> findAll(Pageable pageable);
}
