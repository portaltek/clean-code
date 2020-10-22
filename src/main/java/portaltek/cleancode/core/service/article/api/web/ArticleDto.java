package portaltek.cleancode.core.service.article.api.web;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Getter
@EqualsAndHashCode
class ArticleDto {
    private String title;
    private LocalDate published;
    private String body;
    private String author;
}
