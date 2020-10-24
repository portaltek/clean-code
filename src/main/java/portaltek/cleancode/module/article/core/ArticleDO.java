package portaltek.cleancode.module.article.core;

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
public class ArticleDO {
    private String title;
    private LocalDate published;
    private String body;
    private String author;


}
