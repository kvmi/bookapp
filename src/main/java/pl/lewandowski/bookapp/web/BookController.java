package pl.lewandowski.bookapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.lewandowski.bookapp.domain.Book;
import pl.lewandowski.bookapp.domain.Person;
import pl.lewandowski.bookapp.service.BookService;

@Controller
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;

        Person testPerson = new Person("Henryk", 1846);
        testPerson.setId("testId");
        Book testBook = new Book("W pustyni i w puszczy", "978-83-240-2959-4", testPerson);
        bookService.addBook(testBook);
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("bookList", bookService.getAllBooks());
        return "books";
    }
}
