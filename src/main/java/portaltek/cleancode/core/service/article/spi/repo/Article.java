package portaltek.cleancode.core.service.article.spi.repo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Accessors(fluent = true)
class Article {
    private String title;
    private LocalDate published;
    private String body;
    private String author;


}
