package nvb.springframework.bookmanager.service;

import lombok.AllArgsConstructor;
import nvb.springframework.bookmanager.exception.ResourceNotFoundException;
import nvb.springframework.bookmanager.model.Book;
import nvb.springframework.bookmanager.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "ID", bookId));
    }

    public Book addBook(Book bookRequest) {
        return bookRepository.save(bookRequest);
    }

    public Book updateBook(Long bookId, Book bookRequest) {
        return bookRepository.findById(bookId).map(book -> {
            book.setName(bookRequest.getName());
            book.setAuthor(bookRequest.getAuthor());
            book.setIsbn(bookRequest.getIsbn());
            book.setLanguage(bookRequest.getLanguage());
            book.setLength(bookRequest.getLength());
            book.setPublisher(bookRequest.getPublisher());
            book.setReleaseDate(bookRequest.getReleaseDate());
            book.setWeight(bookRequest.getWeight());
            book.setBookCategory(bookRequest.getBookCategory());
            return bookRepository.save(book);
        }).orElseThrow(() -> new ResourceNotFoundException("Mission", "ID", bookId));
    }

    public Boolean deleteBook(Long bookId) {
        return bookRepository.findById(bookId).map(book -> {
            bookRepository.delete(book);
            return true;
        }).orElseThrow(() -> new ResourceNotFoundException("Book", "ID", bookId));
    }

}
