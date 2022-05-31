package com.example.spring02.repository;

import com.example.spring02.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    @Query(value = "SELECT * FROM Persona p WHERE p.dni = ?1", nativeQuery = true)
    Persona findByDni (String dni);
}
