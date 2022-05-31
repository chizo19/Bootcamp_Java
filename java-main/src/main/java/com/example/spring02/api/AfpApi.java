package com.example.spring02.api;

import com.example.spring02.exception.ModeloNotFoundException;
import com.example.spring02.model.Afp;
import com.example.spring02.service.AfpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "afp")
public class AfpApi {
    @Autowired
    AfpService afpService;

    @GetMapping
    public ResponseEntity<List<Afp>> findAll(){
        return ResponseEntity.ok(afpService.findAll());
    }

    @PostMapping
    public ResponseEntity<Afp> create(@Valid @RequestBody Afp afp){
        Afp find = afpService.findByDesc(afp.getDescripcion());

        if(find != null){
            throw new ModeloNotFoundException("La descripción de la AFP ya existe");
        }

        Afp afpResponse = afpService.create(afp);
        return new ResponseEntity<>(afpResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Afp> update(@Valid @RequestBody Afp afp){
        Afp find = afpService.findByDesc(afp.getDescripcion());

        if(find != null){
            if(find.getId() != afp.getId()){
                throw new ModeloNotFoundException("La descripción de la AFP ya existe");
            }
        }

        return ResponseEntity.ok(afpService.update(afp));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Afp> findById(@PathVariable("id") long id){
        Afp afp = afpService.findById(id);

        if(afp.getId() == 0){
            throw new ModeloNotFoundException("ID no encontrado");
        }

        return ResponseEntity.ok(afpService.findById(id));
    }

    @GetMapping("/find/{desc}")
    public ResponseEntity<Afp> findByDesc(@PathVariable("desc") String desc){
        Afp afp = afpService.findByDesc(desc);

        if(afp == null){
            throw new ModeloNotFoundException("Afp no encontrado");
        }

        return ResponseEntity.ok(afpService.findByDesc(desc));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id){
        Afp afp = afpService.findById(id);

        if(afp.getId() == 0){
            throw new ModeloNotFoundException("ID no encontrado");
        }

        afpService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}