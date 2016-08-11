package com.demo.dao;

import com.demo.model.Book;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds the CRUD operations for {@link com.demo.model.Book} entity.
 */
@Component
public class BookDao extends ParentDao<Book>{

    public Book findByBookTitle(String name){
        Query query = getSession().createQuery("from Book b where b.title = :name");
        query.setParameter("name", name);
        List<Book> list = query.getResultList();

        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        return list.get(0);
    }
}
