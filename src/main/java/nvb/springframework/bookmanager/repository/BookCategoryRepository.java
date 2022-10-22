package nvb.springframework.bookmanager.repository;

import nvb.springframework.bookmanager.model.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {
}
