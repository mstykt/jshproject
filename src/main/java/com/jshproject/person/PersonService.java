package com.jshproject.person;

import com.jshproject.common.GenericService;
import com.jshproject.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mesut on 23.10.2016.
 */
@Service
@Transactional
public class PersonService extends GenericService<Person> {

    /*@Autowired
    private PersonDAO personDAO;

    public List<Person> findAll() {
        return personDAO.findAll();
    }*/
}
