package service.impl;

import model.Book;
import service.dao.BookDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MemBookDao implements BookDao {
    private List<Book> books = new ArrayList<>();

    public MemBookDao() {
        List<String> oneAuthors = Arrays.asList("AuthorOne");
        List<String> twoAuthors = Arrays.asList("AuthorOne", "AuthorTwo");
        List<String> threeAuthors = Arrays.asList("AuthorThree");
        List<String> fourAuthors = Arrays.asList("AuthorFour");
        List<String> fiveAuthors = Arrays.asList("AuthorFive");

        Book book1 = new Book("1", "bookOne", "This is bookOne.", 111, oneAuthors);
        Book book2 = new Book("2", "bookTwo", "This is bookTwo.", 222, twoAuthors);
        Book book3 = new Book("3", "bookThree", "This is bookThree", 333, threeAuthors);
        Book book4 = new Book("4", "bookFour", "This is bookFour.", 444, fourAuthors);
        Book book5 = new Book("5", "bookFive", "This is book five.", 555, fiveAuthors);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
    }

    @Override
    public List<Book> list() {
        System.out.println(books);
        return this.books;
    }

    @Override
    public Book find(String key) {
        for (Book book : this.books) {
            if (book.getIsbn().equals(key)) {
                return book;
            }
        }
        return new Book();
    }
}
