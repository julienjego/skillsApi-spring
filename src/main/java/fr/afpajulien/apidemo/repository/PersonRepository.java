package fr.afpajulien.apidemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.afpajulien.apidemo.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}
