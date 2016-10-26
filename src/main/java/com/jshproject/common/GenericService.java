package com.jshproject.common;

import com.jshproject.model.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mesut on 23.10.2016.
 */
@Service
@Transactional
public abstract class GenericService<T extends BaseModel> implements Serializable {

    @Autowired
    protected GenericDAO<T> genericDAO;

    public Long save(final T t) {
        if (t == null) {
            throw new RuntimeException("Object can not be null!");
        }
        return genericDAO.save(t);
    }

    public T findById(final Long id) {
        if (id == null) {
            throw new RuntimeException("Id can not be null!");
        }

        return genericDAO.findById(id);
    }

    public T update(final T t) {
        if (t == null) {
            throw new RuntimeException("Object can not be null!");
        }

        return genericDAO.update(t);
    }

    public T delete(final T t) {
        if (t == null) {
            throw new RuntimeException("Object can not be null!");
        }

        return genericDAO.delete(t);
    }

    public List<T> findAll() {
        return genericDAO.findAll();
    }
}
