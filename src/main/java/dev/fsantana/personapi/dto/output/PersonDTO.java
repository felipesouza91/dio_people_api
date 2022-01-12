package dev.fsantana.personapi.dto.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
  private Long id;
  private String firstName;
  private String  lastName;
  private String cpf;
  private LocalDate birthday;
  private List<PhoneDTO> phones;
}
