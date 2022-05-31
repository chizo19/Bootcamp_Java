package com.example.spring02.service;

import com.example.spring02.model.Persona;
import java.util.List;

public interface PersonaService {
    List<Persona> findAll();
    Persona create(Persona persona);
    Persona update(Persona persona);
    void delete(long id);
    Persona findById(long id);
    Persona findByDni(String dni);
}
