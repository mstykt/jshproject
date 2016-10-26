package com.jshproject.person;

import com.jshproject.common.GenericDAO;
import com.jshproject.model.Person;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by mesut on 23.10.2016.
 */
@Repository
public class PersonDAO extends GenericDAO<Person> {

    /*public List<Person> findAll() {
        final Session session = super.sessionFactory.getCurrentSession();

        Query query = session.createQuery("From PERSON");

        return query.getResultList();
    }*/
}
