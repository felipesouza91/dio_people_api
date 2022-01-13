package dev.fsantana.personapi.services;

import dev.fsantana.personapi.entity.Person;
import dev.fsantana.personapi.erros.PersonNotFoundException;
import dev.fsantana.personapi.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

  public Person findById(Long id) {
    Optional<Person> personOptional = this.repository.findById(id);
    return personOptional.orElseThrow(() -> new PersonNotFoundException("Person not found!"));
  }

  public void delete(Long id) {
    findById(id);
    this.repository.deleteById(id);
  }

  public Person update(Long id, Person toModel) {
    Person person = this.findById(id);
    toModel.setId(person.getId());
    return this.repository.save(toModel);
  }
}
