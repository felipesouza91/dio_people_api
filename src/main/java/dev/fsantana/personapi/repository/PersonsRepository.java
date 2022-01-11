package dev.fsantana.personapi.repository;

import dev.fsantana.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonsRepository extends JpaRepository<Person, Long> {
}
