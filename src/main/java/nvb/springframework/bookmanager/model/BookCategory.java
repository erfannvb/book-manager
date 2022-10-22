package nvb.springframework.bookmanager.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Entity
@Table(name = "book_category")
public class BookCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private @NonNull String name;

    @OneToMany(mappedBy = "bookCategory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Book> books;

}
