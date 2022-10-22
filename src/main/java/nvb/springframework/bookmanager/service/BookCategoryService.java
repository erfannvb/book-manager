package nvb.springframework.bookmanager.service;

import lombok.AllArgsConstructor;
import nvb.springframework.bookmanager.exception.ResourceNotFoundException;
import nvb.springframework.bookmanager.model.BookCategory;
import nvb.springframework.bookmanager.repository.BookCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookCategoryService {

    private final BookCategoryRepository bookCategoryRepository;

    public List<BookCategory> findAllBookCategories() {
        return bookCategoryRepository.findAll();
    }

    public BookCategory findBookCategoryById(Long bookCategoryId) {
        return bookCategoryRepository.findById(bookCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException("BookCategory", "ID", bookCategoryId));
    }

    public BookCategory addBookCategory(BookCategory bookCategoryRequest) {
        return bookCategoryRepository.save(bookCategoryRequest);
    }

    public BookCategory updateBookCategory(Long bookCategoryId, BookCategory bookCategoryRequest) {
        return bookCategoryRepository.findById(bookCategoryId).map(bookCategory -> {
            bookCategory.setName(bookCategoryRequest.getName());
            return bookCategoryRepository.save(bookCategory);
        }).orElseThrow(() -> new ResourceNotFoundException("Mission", "ID", bookCategoryId));
    }

    public Boolean deleteBookCategory(Long bookCategoryId) {
        return bookCategoryRepository.findById(bookCategoryId).map(bookCategory -> {
            bookCategoryRepository.delete(bookCategory);
            return true;
        }).orElseThrow(() -> new ResourceNotFoundException("BookCategory", "ID", bookCategoryId));
    }

}
