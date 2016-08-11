package com.demo.service;

import com.demo.model.Author;
import com.demo.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.number.OrderingComparison.greaterThan;

/**
 * Test things on {@link BookService} class.
 */
@ContextConfiguration(locations = "/applicationContext-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BookServiceTest {

    /**
     * Injects {@link BookService} instance to this class.
     */
    @Autowired
    private BookService bookService;

    /**
     * Saves book after this class is constructed.
     * @throws Throwable
     */
    @PostConstruct
    public void init() throws Throwable {

        List<Author> authors = new ArrayList<Author>();

        Book book = new Book();
        book.setTitle("Programming in Scala");
        book.setTimeCreated(new Date());
        book.setTimeUpdated(new Date());

        Author author = new Author();
        author.setGivenName("Martin");
        author.setFamilyName("Odersky");
        author.setTimeCreated(new Date());
        author.setTimeUpdated(new Date());
        authors.add(author);

        author = new Author();
        author.setGivenName("Lex");
        author.setFamilyName("Spoon");
        author.setTimeCreated(new Date());
        author.setTimeUpdated(new Date());
        authors.add(author);

        book.setAuthors(authors);

        bookService.saveBook(book);
    }

    @Test
    public void getBook() throws Exception {
        Book book = bookService.getBook(1);
        assertThat(book, is(notNullValue()));
    }

    @Test
    public void getBooks() throws Exception {
        List<Book> books = bookService.getBooks();
        assertThat(books, is(notNullValue()));
        assertThat(books.size(), is(greaterThan(0)));
    }

    @Test
    public void updateBook() throws Exception {

        Book book = bookService.getBookByTitle("Programming in Scala");
        book.setTitle("Programming in Scala 2nd Edition");
        Book modifiedBook = bookService.updateBook(book);

        assertThat(book, is(notNullValue()));
        assertThat(modifiedBook.getTitle(), is("Programming in Scala 2nd Edition"));
    }

    @Test
    public void removeBook() throws Exception {
        Book book = bookService.getBook(1L);
        bookService.deleteBook(book);

        book = bookService.getBook(1);
        assertThat(book, is(nullValue()));

    }
}