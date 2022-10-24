package fr.afpajulien.apidemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.afpajulien.apidemo.model.Person;
import fr.afpajulien.apidemo.service.PersonServiceImpl;
import static org.springframework.http.HttpStatus.*;

@RestController
public class PersonController {

    @Autowired
    private PersonServiceImpl psi;

    @GetMapping("/persons")
    public List<Person> getPersons() {
        return psi.fetchPersonList();
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long id) {

        Person person = psi.fetchPerson(id).orElseGet(() -> null);

        return new ResponseEntity<>(person, person != null ? OK : NOT_FOUND);
    }

    @PostMapping("/person")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        return new ResponseEntity<>(psi.savePerson(person), CREATED);
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable("id") Long id) {
        psi.deletePerson(id);
    }
}
