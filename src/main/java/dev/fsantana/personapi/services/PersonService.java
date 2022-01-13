package dev.fsantana.personapi.services;

import dev.fsantana.personapi.entity.Person;
import dev.fsantana.personapi.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

  @Autowired
  private PersonsRepository repository;

  public Person savePerson(Person person ) {
    return this.repository.save(person);
  }

  public List<Person> findAll(){
    return this.repository.findAll();
  }
}
