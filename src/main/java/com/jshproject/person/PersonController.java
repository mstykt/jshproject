package com.jshproject.person;

import com.jshproject.model.Person;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

/**
 * Created by mesut on 23.10.2016.
 */
@Named
public class PersonController {

    @Inject
    private PersonService personService;
    private List<Person> persons;
    private String deneme;

    @PostConstruct
    public void init() {
        persons = personService.findAll();
    }

    public String getDeneme() {
        return "adsfdsfdfds";
    }

    public void setDeneme(String deneme) {
        this.deneme = "deneme degiskeni";
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
