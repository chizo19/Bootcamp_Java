package com.example.spring02.api;

import com.example.spring02.exception.ModeloNotFoundException;
import com.example.spring02.model.Persona;
import com.example.spring02.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "personas")
public class PersonaApi {
    @Autowired
    PersonaService personaService;

    @GetMapping
    public ResponseEntity<List<Persona>> findAll(){
        return ResponseEntity.ok(personaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Persona> create(@Valid @RequestBody Persona persona){
        Persona find = personaService.findByDni(persona.getDni());

        if(find != null){
            throw new ModeloNotFoundException("El DNI ingresado ya existe");
        }

        Persona personResponse = personaService.create(persona);
        return new ResponseEntity<>(personResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Persona> update(@Valid @RequestBody Persona persona){
        Persona find = personaService.findByDni(persona.getDni());

        if(find != null){
            if(find.getId() != persona.getId()){
                throw new ModeloNotFoundException("El DNI ingresado ya existe.");
            }
        }

        return ResponseEntity.ok(personaService.update(persona));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> findById(@PathVariable("id") long id){
        Persona persona = personaService.findById(id);
        if(persona.getId() == 0){
            throw  new ModeloNotFoundException("ID no encontrado");
        }
        return ResponseEntity.ok(personaService.findById(id));
    }

    @GetMapping("/find/{dni}")
    public ResponseEntity<Persona> findByDni(@PathVariable("dni") String dni){
        Persona persona = personaService.findByDni(dni);

        if(persona == null){
            throw new ModeloNotFoundException("Persona no encontrado");
        }

        return ResponseEntity.ok(personaService.findByDni(dni));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id){
        Persona persona = personaService.findById(id);
        if(persona.getId() == 0){
            throw  new ModeloNotFoundException("ID no encontrado");
        }
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
