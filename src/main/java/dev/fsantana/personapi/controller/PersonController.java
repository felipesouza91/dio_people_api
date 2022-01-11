package dev.fsantana.personapi.controller;

import dev.fsantana.personapi.entity.Person;
import dev.fsantana.personapi.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

  @Autowired
  private PersonsRepository repository;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Person savePerson(@RequestBody() Person person) {
    return this.repository.save(person);
  }
}
