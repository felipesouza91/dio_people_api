package dev.fsantana.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name="first_name", nullable = false)
  private String firstName;

  @Column(name="last_name", nullable = false)
  private String lastName;

  @Column(name="cpf", nullable = false, unique = true)
  private String cpf;

  private LocalDate birthday;

  @OneToMany(fetch = FetchType.LAZY,
      cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
  private List<Phone> phones;
}
