package portaltek.cleancode.core.service.article.api.web;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import portaltek.cleancode.core.service.article.api.web.ArticleDto;
import portaltek.cleancode.core.service.article.domain.ArticleDO;
import portaltek.cleancode.core.service.article.domain.ArticleRepo;

import static java.util.Objects.requireNonNull;

@AllArgsConstructor
class ArticleFacade {

    private ArticleRepo articleRepo;
    private ArticleConverter articleConverter;


    public ArticleDto findByTitle(String title) {
        requireNonNull(title);
        ArticleDO article = articleRepo.findById(title);
        return articleConverter.convert(article);
    }

    public Page<ArticleDto> findAll(Pageable pageable) {
        requireNonNull(pageable);
        return articleRepo
                .findAll(pageable)
                .map(articleConverter::convert);
    }

}
