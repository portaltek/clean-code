package portaltek.cleancode.core.service.article.api.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
class ArticleController {

    final ArticleWebFacade facade;

    public ArticleController(ArticleWebFacade facade) {
        this.facade = facade;
    }

    @GetMapping("article")
    Page<ArticleDto> getPage(Pageable pageable) {
        return facade.findAll(pageable);
    }

    @GetMapping("article/{title}")
    ArticleDto getByTitle(@PathVariable String title) {
        return facade.findByTitle(title);
    }
}
