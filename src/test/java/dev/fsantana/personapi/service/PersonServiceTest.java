package dev.fsantana.personapi.service;

import dev.fsantana.personapi.dto.input.PersonInputDTO;
import dev.fsantana.personapi.entity.Person;
import dev.fsantana.personapi.entity.Phone;
import dev.fsantana.personapi.enums.PhoneType;
import dev.fsantana.personapi.repository.PersonsRepository;
import dev.fsantana.personapi.services.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.JUnitException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

  @Mock
  private PersonsRepository repository;

  @InjectMocks
  private PersonService personService;

  @Test
  public void testGivenValidPersonDataThenReturnPerson() {
    Mockito.when(repository.save(fakeInputData())).thenReturn(fakeSavedData());
    Person result = personService.savePerson(fakeInputData());
    Assertions.assertEquals(fakeSavedData(), result);
  }



  private Person fakeInputData() {
    Phone phone = Phone.builder().number("12345-6789").type(PhoneType.HOME).build();
    return Person.builder().birthday(LocalDate.now())
        .cpf("123.456.789-10")
        .firstName("Felipe")
        .lastName("Santana").phones(List.of(phone))
        .build();
  }

  private Person fakeSavedData() {
    Phone phone = Phone.builder().number("12345-6789").type(PhoneType.HOME).build();
    return Person.builder().birthday(LocalDate.now())
        .id(1L)
        .cpf("123.456.789-10")
        .firstName("Felipe")
        .lastName("Santana").phones(List.of(phone))
        .build();
  }
}
