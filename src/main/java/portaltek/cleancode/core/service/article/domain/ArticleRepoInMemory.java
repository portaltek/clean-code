package portaltek.cleancode.core.service.article.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

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
