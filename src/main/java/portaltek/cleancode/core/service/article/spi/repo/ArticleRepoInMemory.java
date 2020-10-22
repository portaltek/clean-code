package portaltek.cleancode.core.service.article.spi.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import portaltek.cleancode.core.service.article.core.ArticleDO;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

class ArticleRepoInMemory implements ArticleRepo {

    private ConcurrentHashMap<String, ArticleDO> map = new ConcurrentHashMap<>();

    @Override
    public ArticleDO findById(String title) {
        return map.get(title);
    }

    @Override
    public Page<ArticleDO> findAll(Pageable pageable) {
        return new PageImpl<>(new ArrayList<>(map.values()), pageable, map.size());
    }
}

