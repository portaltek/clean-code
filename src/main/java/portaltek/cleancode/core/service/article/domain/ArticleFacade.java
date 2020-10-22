package portaltek.cleancode.core.service.article.domain;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static java.util.Objects.requireNonNull;

public class ArticleFacade {

    private ArticleRepo articleRepo;

    public ArticleFacade(ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;
    }

    public  ArticleDto find(String filmDto) {
        requireNonNull(filmDto);
        ArticleDO article = articleRepo.findById(filmDto);
        return article.dto();
    }

    public Page<ArticleDto> findAll(Pageable pageable) {
        requireNonNull(pageable);
        return articleRepo
                .findAll(pageable)
                .map(film -> film.dto());
    }

}
