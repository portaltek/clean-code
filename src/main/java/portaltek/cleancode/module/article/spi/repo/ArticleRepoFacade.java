package portaltek.cleancode.module.article.spi.repo;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import portaltek.cleancode.module.article.core.ArticleDO;
import portaltek.cleancode.module.article.core.ArticleRepoFacade;

import static java.util.Objects.requireNonNull;

@AllArgsConstructor
class ArticleRepoFacadeImpl implements ArticleRepoFacade {

    private ArticleRepo articleRepo;
    private ArticleRepoConverter articleRepoConverter;


    public ArticleDO findByTitle(String title) {
        requireNonNull(title);
        Article article = articleRepo.findById(title);
        return articleRepoConverter.toDomain(article);
    }

    public Page<ArticleDO> findAll(Pageable pageable) {
        requireNonNull(pageable);
        return articleRepo
                .findAll(pageable)
                .map(articleRepoConverter::toDomain);
    }

}
