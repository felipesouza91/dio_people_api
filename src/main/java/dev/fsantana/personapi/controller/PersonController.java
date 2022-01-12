package dev.fsantana.personapi.controller;

import dev.fsantana.personapi.dto.input.PersonInputDTO;
import dev.fsantana.personapi.entity.Person;
import dev.fsantana.personapi.entity.Phone;
import dev.fsantana.personapi.repository.PersonsRepository;
import dev.fsantana.personapi.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/person")
public class PersonController {

  @Autowired
  private PersonService personService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Person savePerson(@RequestBody() @Valid PersonInputDTO personDto) {
    List<Phone> phones = personDto.getPhones().stream()
        .map( input -> Phone.builder().number(input.getNumber())
            .type(input.getType()).build()
        ).collect(Collectors.toList());
    Person person = Person.builder().cpf(personDto.getCpf()).birthday(personDto.getBirthday())
        .firstName(personDto.getFirstName()).lastName(personDto.getLastName())
          .phones(phones).build();
    return this.personService.savePerson(person);
  }
}
