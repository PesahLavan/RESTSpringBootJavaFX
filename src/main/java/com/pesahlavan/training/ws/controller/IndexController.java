package com.pesahlavan.training.ws.controller;


import com.pesahlavan.training.javafx.entity.Person;
import com.pesahlavan.training.javafx.repository.PersonRepository;
import com.pesahlavan.training.javafx.service.ListWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (value = "/addressbook")
public class IndexController {

    @Autowired
    private PersonRepository personRepository;


    @RequestMapping (value = "/all")
    public ListWrapper findAll(@RequestParam(value="from", defaultValue="0") int from, @RequestParam(value="count", defaultValue="10") int count){
        Page<Person> page = personRepository.findAll(new PageRequest(from, count, Sort.Direction.ASC, "fio"));
        ListWrapper wrappper = new ListWrapper(page.getContent(), page.getTotalElements());
        return wrappper;
    }

    @RequestMapping (value = "/search")
    public ListWrapper findAll(@RequestParam(value="from", defaultValue="0") int from, @RequestParam(value="count", defaultValue="10") int count, @RequestParam(value="text", defaultValue="") String text) {
        Page<Person> page = personRepository.findByFioContainingIgnoreCase(text, new PageRequest(from, count, Sort.Direction.ASC, "fio"));
        ListWrapper wrappper = new ListWrapper(page.getContent(), page.getTotalElements());
        return wrappper;
    }

}