package portaltek.cleancode.core.service.article.core;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import portaltek.cleancode.core.service.article.spi.repo.ArticleRepo;

@Service
@AllArgsConstructor
class ArticleServiceImpl implements ArticleService {

    ArticleRepo repo;

    public ArticleDO findByTitle(String title){
        return repo.findById(title);
    }

    public Page<ArticleDO> findAll(Pageable pageable){
        return repo.findAll(pageable);
    }
}
