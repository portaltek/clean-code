package portaltek.cleancode.core.service.article;


import org.springframework.web.bind.annotation.RestController;
import portaltek.cleancode.core.service.article.domain.ArticleFacade;

@RestController
class ArticleController {

    final private ArticleFacade facade;

    public ArticleController(ArticleFacade facade) {
        this.facade = facade;
    }


}
