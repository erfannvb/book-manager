package nvb.springframework.bookmanager.controller;

import lombok.AllArgsConstructor;
import nvb.springframework.bookmanager.model.Book;
import nvb.springframework.bookmanager.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBooksById(@PathVariable Long bookId) {
        return new ResponseEntity<>(bookService.findBookById(bookId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book bookRequest) {
        return new ResponseEntity<>(bookService.addBook(bookRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable Long bookId, @Validated @RequestBody Book bookRequest) {
        return new ResponseEntity<>(bookService.updateBook(bookId, bookRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
