package com.pesahlavan.training.ws.controller;


import com.pesahlavan.training.javafx.entity.Person;
import com.pesahlavan.training.javafx.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping (value = "/addressbook")
public class IndexController {

    @Autowired
    private PersonRepository personRepository;


    @RequestMapping (value = "/all")
    public List<Person> findAll() {
        return personRepository.findAll();
    }

}
