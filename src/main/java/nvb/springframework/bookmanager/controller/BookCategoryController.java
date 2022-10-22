package nvb.springframework.bookmanager.controller;

import lombok.AllArgsConstructor;
import nvb.springframework.bookmanager.model.BookCategory;
import nvb.springframework.bookmanager.service.BookCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookCategories")
@AllArgsConstructor
public class BookCategoryController {

    private final BookCategoryService bookCategoryService;

    @GetMapping
    public ResponseEntity<List<BookCategory>> getBookCategories() {
        return new ResponseEntity<>(bookCategoryService.findAllBookCategories(), HttpStatus.OK);
    }

    @GetMapping("/{bookCategoryId}")
    public ResponseEntity<BookCategory> getBookCategoryById(@PathVariable Long bookCategoryId) {
        return new ResponseEntity<>(bookCategoryService.findBookCategoryById(bookCategoryId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookCategory> createBookCategory(@RequestBody BookCategory bookCategoryRequest) {
        return new ResponseEntity<>(bookCategoryService.addBookCategory(bookCategoryRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{bookCategoryId}")
    public ResponseEntity<BookCategory> updateBookCategory(@PathVariable Long bookCategoryId,
                                                           @Validated @RequestBody BookCategory bookCategoryRequest) {
        return new ResponseEntity<>(bookCategoryService.updateBookCategory(bookCategoryId, bookCategoryRequest),
                HttpStatus.OK);
    }

    @DeleteMapping("/{bookCategoryId}")
    public ResponseEntity<Void> deleteBookCategory(@PathVariable Long bookCategoryId) {
        bookCategoryService.deleteBookCategory(bookCategoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
