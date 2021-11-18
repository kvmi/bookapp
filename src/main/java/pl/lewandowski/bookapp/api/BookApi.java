package pl.lewandowski.bookapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lewandowski.bookapp.domain.Book;
import pl.lewandowski.bookapp.service.BookService;

import java.util.List;

@RestController
public class BookApi {

    private BookService bookService;

    @Autowired
    public BookApi(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/books")
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @PostMapping("/api/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        if (bookService.addBook(book) == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
    }

    @PutMapping("/api/books/{isbn}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable String isbn) {
        return new ResponseEntity<>(bookService.updateBook(isbn, book), HttpStatus.OK);
    }

    @DeleteMapping("/api/books/{isbn}")
    public ResponseEntity deleteBook(@PathVariable String isbn) {
        bookService.deleteBook(isbn);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
