package portaltek.cleancode.core.service.article.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
class ArticleDO {
    private String title;
    private LocalDate published;
    private String body;
    private String author;

    ArticleDto dto() {
        return ArticleDto.builder()
                .title(title)
                .published(published)
                .body(body)
                .author(author)
                .build();
    }
}
