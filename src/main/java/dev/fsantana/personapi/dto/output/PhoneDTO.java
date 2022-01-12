package dev.fsantana.personapi.dto.output;

import dev.fsantana.personapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {
  private Long id;
  private PhoneType type;
  private String number;
}
