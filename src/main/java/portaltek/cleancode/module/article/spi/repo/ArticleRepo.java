package portaltek.cleancode.module.article.spi.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

interface ArticleRepo {
    Article findById(String id);

    Page<Article> findAll(Pageable pageable);
}
