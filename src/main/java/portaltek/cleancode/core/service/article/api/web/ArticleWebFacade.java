package portaltek.cleancode.core.service.article.api.web;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import portaltek.cleancode.core.service.article.core.ArticleDO;
import portaltek.cleancode.core.service.article.core.ArticleService;

import static java.util.Objects.requireNonNull;


class ArticleWebFacade {

    private ArticleService articleService;
    private ArticleConverter articleConverter;

    public ArticleWebFacade(ArticleService articleService,
                            ArticleConverter articleConverter) {
        this.articleService = articleService;
        this.articleConverter = articleConverter;
    }

    public ArticleDto findByTitle(String title) {
        requireNonNull(title);
        ArticleDO article = articleService.findByTitle(title);
        return articleConverter.fromDomain(article);
    }

    public Page<ArticleDto> findAll(Pageable pageable) {
        requireNonNull(pageable);
        return articleService
                .findAll(pageable)
                .map(articleConverter::fromDomain);
    }

}
