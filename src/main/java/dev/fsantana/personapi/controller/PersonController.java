package dev.fsantana.personapi.controller;

import dev.fsantana.mapper.PersonMapper;
import dev.fsantana.personapi.dto.input.PersonInputDTO;
import dev.fsantana.personapi.dto.output.PersonDTO;
import dev.fsantana.personapi.entity.Person;
import dev.fsantana.personapi.entity.Phone;
import dev.fsantana.personapi.repository.PersonsRepository;
import dev.fsantana.personapi.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

  @Autowired
  private PersonService personService;

  private PersonMapper mapper = PersonMapper.INSTANCE;

  @GetMapping
  public List<PersonDTO> getAll() {
    List<Person> list = this.personService.findAll();
    return this.mapper.toDTOList(list);
  }

  @GetMapping("{/id}")
  public PersonDTO getPerson(@RequestParam Long id) {
    Person person = this.personService.findById(id);
    return this.mapper.toDTO(person);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Person savePerson(@RequestBody PersonInputDTO personDto) {
    Person person = mapper.toModel(personDto);
    return this.personService.savePerson(person);
  }

  @PutMapping("{/id}")
  @ResponseStatus(HttpStatus.CREATED)
  public Person savePerson(@RequestParam Long id,@RequestBody PersonInputDTO personDto) {
    Person person = this.personService.update(id, mapper.toModel(personDto));
    return this.personService.savePerson(person);
  }


  @DeleteMapping("{/id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void remove(Long id) {
    this.personService.delete(id);
  }
}
