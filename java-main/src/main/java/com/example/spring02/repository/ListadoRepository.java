package com.example.spring02.repository;

import com.example.spring02.model.Listado;
import com.example.spring02.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ListadoRepository extends JpaRepository<Listado, Long> {
    @Query(value = "SELECT * FROM Listado l WHERE l.dni = ?1", nativeQuery = true)
    Listado findByDni (String dni);
}
