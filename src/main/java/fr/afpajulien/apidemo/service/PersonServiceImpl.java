package fr.afpajulien.apidemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpajulien.apidemo.model.Person;
import fr.afpajulien.apidemo.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository pr;

    @Override
    public Person savePerson(Person person) {
        return pr.save(person);
    }

    @Override
    public Optional<Person> fetchPerson(Long id) {
        return pr.findById(id);
    }

    @Override
    public List<Person> fetchPersonList() {
        return (List<Person>) pr.findAll();
    }

    @Override
    public Person updatePerson(Person person, Long id) {

        Optional<Person> p = pr.findById(id);

        if (p.isPresent()) {
            Person currentPerson = p.get();

            currentPerson.setFirstName(person.getFirstName());
            currentPerson.setLastName(person.getLastName());
            currentPerson.setBirthDate(person.getBirthDate());

            return currentPerson;

        } else {
            return null;
        }
    }

    @Override
    public void deletePerson(Long id) {
        pr.deleteById(id);

    }

}
