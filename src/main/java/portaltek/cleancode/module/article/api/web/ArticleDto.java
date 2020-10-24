package portaltek.cleancode.module.article.api.web;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Builder
@Getter
@EqualsAndHashCode
@Accessors(fluent = true)
class ArticleDto {
    private String title;
    private LocalDate published;
    private String body;
    private String author;
}
