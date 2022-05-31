package com.example.spring02.service.impl;

import com.example.spring02.model.Persona;
import com.example.spring02.repository.PersonaRepository;
import com.example.spring02.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    @Override
    public Persona create(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona update(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public void delete(long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Persona findById(long id) {
        Optional<Persona> op =  personaRepository.findById(id);
        return op.isPresent() ? op.get() : new Persona();
    }

    @Override
    public Persona findByDni(String dni){
        return personaRepository.findByDni(dni);
    }
}
