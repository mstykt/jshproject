package com.jshproject.common;

import com.jshproject.model.BaseModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by mesut on 23.10.2016.
 */
public abstract class GenericDAO<T extends BaseModel> implements Serializable {

    @Autowired
    protected SessionFactory sessionFactory;
    final protected Class<T> classType;

    public GenericDAO() {
        this.classType = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    public Long save(final T t) {
        final Session session = sessionFactory.getCurrentSession();

        return (Long) session.save(t);
    }

    public T findById(Long id) {
        final Session session = sessionFactory.getCurrentSession();

        return session.get(classType, id);
    }

    public T update(final T t) {
        final Session session = sessionFactory.getCurrentSession();

        return (T) session.merge(t);
    }

    public T delete(final T t) {
        final Session session = sessionFactory.getCurrentSession();
        t.setActive(false);
        t.setDeleted(true);

        return (T) session.merge(t);
    }

    public List<T> findAll() {
        final Session session = sessionFactory.getCurrentSession();
        String hql = "From " + classType.getSimpleName() + " T WHERE T.active = :active and T.deleted = :deleted";
        Query query = session.createQuery(hql);
        query.setParameter("active", true);
        query.setParameter("deleted", false);

        return query.getResultList();
    }
}
