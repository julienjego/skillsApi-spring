package fr.afpajulien.apidemo.service;

import java.util.List;
import java.util.Optional;

import fr.afpajulien.apidemo.model.Person;

public interface PersonService {

    // Create a new person
    Person savePerson(Person person);

    // Read a person
    Optional<Person> fetchPerson(final Long id);

    // Read all persons
    List<Person> fetchPersonList();

    // Update a person
    Person updatePerson(Person person, Long id);

    // Delete a person
    void deletePerson(final Long id);

}
