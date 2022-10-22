package nvb.springframework.bookmanager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@RequiredArgsConstructor
@ToString(exclude = "bookCategory")
@EqualsAndHashCode(exclude = "bookCategory")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private @NonNull String name;
    private @NonNull String author;
    private @NonNull String language;
    private @NonNull String isbn;

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss z")
    private @NonNull Date releaseDate;
    private @NonNull String publisher;
    private @NonNull long length;
    private @NonNull double weight;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_category_id")
    private @NonNull BookCategory bookCategory;

}
