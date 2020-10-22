package portaltek.cleancode.core.service.article.api.web;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import portaltek.cleancode.core.service.article.domain.ArticleFacade;

@RestController
class ArticleController {

    final private ArticleFacade facade;

    public ArticleController(ArticleFacade facade) {
        this.facade = facade;
    }

    @GetMapping("article")
    Page<ArticleDto> getPage(Pageable pageable) {
        return facade.findAll(pageable);
    }

    @GetMapping("article/{title}")
    ArticleDto getByTitle(@PathVariable String title) {
        return facade.find(title);
    }
}
