package pl.lewandowski.bookapp.service;

import pl.lewandowski.bookapp.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book addBook(Book book);

    void deleteBook(String isbn);

    Book updateBook(String isbn, Book book);

    Book getBookByIsbn(String isbn);

}
