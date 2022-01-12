package dev.fsantana.personapi.dto.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonInputDTO {

  @NotNull
  private String firstName;

  @NotNull
  private String  lastName;

  @NotNull
  @CPF
  private String cpf;

  @NotNull
  private LocalDate birthday;

  @NotNull
  @Valid
  private List<PhoneInputDTO> phones;
}
