package com.demo.service;

import com.demo.dao.AuthorDao;
import com.demo.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Handles the business logic for {@link com.demo.model.Author}.
 *
 * @author rburawes
 */
@Service
@Transactional
public class AuthorService {

    /**
     * Inject {@link com.demo.dao.AuthorDao} bean instance to this service class.
     */
    @Autowired
    private AuthorDao authorDao;

    public Author getAuthor(long id) throws Exception{
        return authorDao.get(id);
    }

    public List<Author> getAuthors() throws Exception{
        return authorDao.getAll();
    }

    public Author saveAuthor(Author author) throws Exception{
        return authorDao.save(author);
    }

    public Author updateAuthor(Author author) throws Exception{
        return authorDao.update(author);
    }

    public void deleteAuthor(Author author) throws Exception{
        authorDao.delete(author);
    }
}
