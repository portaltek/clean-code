package portaltek.cleancode.core.service.article.api.web;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import portaltek.cleancode.core.service.article.core.ArticleDO;
import portaltek.cleancode.core.service.article.core.ArticleService;

import static java.util.Objects.requireNonNull;

@AllArgsConstructor
@Service
class ArticleWebFacade {

    private ArticleService articleService;
    private ArticleConverter articleConverter;


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
