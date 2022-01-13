package dev.fsantana.mapper;

import dev.fsantana.personapi.dto.input.PersonInputDTO;
import dev.fsantana.personapi.dto.output.PersonDTO;
import dev.fsantana.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PersonMapper {
  PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

  Person toModel(PersonDTO dto);

  Person toModel(PersonInputDTO input);

  PersonDTO toDTO(Person dto);

  List<PersonDTO> toDTOList(List<Person> list);
}
