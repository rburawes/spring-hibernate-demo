package com.demo.service;

import com.demo.dao.BookDao;
import com.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Handles the business logic {@link com.demo.model.Book}.
 *
 * @author rburawes
 */
@Service
@Transactional
public class BookService {

    /**
     * Inject {@link BookDao} bean instance to this service class.
     */
    @Autowired
    private BookDao bookDao;

    public Book getBook(long id) throws Exception{
        return bookDao.get(id);
    }

    public List<Book> getBooks() throws Exception{
        return bookDao.getAll();
    }

    public Book saveBook(Book book) throws Exception{
        return bookDao.save(book);
    }

    public Book updateBook(Book book) throws Exception{
        return bookDao.update(book);
    }

    public void deleteBook(Book book) throws Exception{
        bookDao.delete(book);
    }

    public Book getBookByTitle(String title) throws Exception{
        return bookDao.findByBookTitle(title);
    }
}
