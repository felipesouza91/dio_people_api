package dev.fsantana.personapi.dto.input;

import dev.fsantana.personapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneInputDTO {

  @NotNull
  private PhoneType type;

  @NotNull
  private String number;
}
