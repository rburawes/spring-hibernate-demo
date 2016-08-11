package com.demo.dao;

import com.demo.model.Persistable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * Holds the commonly used methods for CRUD operations.
 * Used to be extended by other DAO classes.
 *
 * @author rburawes
 */
@Component
public abstract class ParentDao<T extends Persistable> {

    /**
     * The parameter type of this class.
     */
    private final Class<T> clazz;

    /**
     * Injects the {@link org.springframework.orm.hibernate5.LocalSessionFactoryBean} to this class.
     * This is the 'sessionFactory' bean defined at 'applicationContex.xml'.
     */
    @Autowired
    private SessionFactory sessionFactory;

    public ParentDao() {
        this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public T get(long id) {
        return (T) getSession().get(clazz, Long.valueOf(id));
    }

    public List<T> getAll() {
        Query query = getSession().createQuery("from " + clazz.getName());
        List<T> list = query.list();

        if (CollectionUtils.isEmpty(list)) {
            return new ArrayList<T>();
        }

        return list;
    }

    public T save(T persistable) {
        return (T) getSession().get(clazz, getSession().save(persistable));
    }

    public T update(T persistable) {
        return (T) getSession().merge(persistable);
    }

    public T merge(T persistable) {
        return (T) getSession().merge(persistable);
    }

    public void delete(T persistable) {
        getSession().remove(persistable);
        getSession().flush();
    }
}
