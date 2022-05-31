package com.example.spring02.repository;

import com.example.spring02.model.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    @Query(value = "SELECT * FROM Solicitud s WHERE s.dni = ?1", nativeQuery = true)
    Solicitud findByDni (String dni);
}
