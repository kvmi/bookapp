package pl.lewandowski.bookapp.service;

import org.springframework.stereotype.Service;
import pl.lewandowski.bookapp.domain.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImplementation implements BookService {

    private List<Book> bookList = new ArrayList<>();

    private boolean checkISBN(String isbn) {

        int modulo;
        int sum = 0;
        int value;

        if (isbn.length() != 13) {
            return false;
        }
        for (int i = 0; i <= 12; i++) {
            value = Integer.parseInt(isbn.substring(i, i + 1));
            if (i % 2 == 0) {
                sum += value * 1;
            } else {
                sum += value * 3;
            }
        }
        modulo = sum % 10;
        if (10 - modulo == 0 || 10 - modulo == 10) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public List<Book> getAllBooks() {
        return bookList;
    }

    @Override
    public Book addBook(Book book) {

        if(checkISBN(book.getISBN().replaceAll("-", ""))) {
            bookList.add(book);
            return book;
        }
        return null;
    }

    @Override
    public void deleteBook(String isbn) {
        bookList.remove(getBookByIsbn(isbn));
    }

    @Override
    public Book updateBook(String isbn, Book book) {
        Book bookToUpdate = getBookByIsbn(isbn);
        bookList.remove(bookToUpdate);
        addBook(book);
        return book;
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        for (Book book : bookList) {
            if (isbn.equals(book.getISBN())) return book;
        }
        return null;
    }
}
