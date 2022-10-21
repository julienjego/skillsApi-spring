package fr.afpajulien.apidemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.afpajulien.apidemo.model.Person;
import fr.afpajulien.apidemo.service.PersonServiceImpl;

@RestController
public class PersonController {

    @Autowired
    private PersonServiceImpl psi;

    @GetMapping("/persons")
    public List<Person> getPersons() {
        return psi.fetchPersonList();
    }

}
