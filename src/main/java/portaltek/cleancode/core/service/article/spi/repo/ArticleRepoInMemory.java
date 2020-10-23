package portaltek.cleancode.core.service.article.spi.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;


class ArticleRepoInMemory implements ArticleRepo {

    private ConcurrentHashMap<String, Article> map = new ConcurrentHashMap<>();

    @Override
    public Article findById(String title) {
        return map.get(title);
    }

    @Override
    public Page<Article> findAll(Pageable pageable) {
        return new PageImpl<>(new ArrayList<>(map.values()), pageable, map.size());
    }
}

