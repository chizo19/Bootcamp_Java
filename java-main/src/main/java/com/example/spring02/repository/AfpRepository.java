package com.example.spring02.repository;

import com.example.spring02.model.Afp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AfpRepository extends JpaRepository<Afp, Long> {
    @Query(value = "SELECT * FROM Afp a WHERE LOWER(a.descripcion) = LOWER(?1)", nativeQuery = true)
    Afp findByDesc(String desc);
}