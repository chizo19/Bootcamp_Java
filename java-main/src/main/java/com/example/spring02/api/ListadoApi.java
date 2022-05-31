package com.example.spring02.api;

import com.example.spring02.exception.ModeloNotFoundException;
import com.example.spring02.model.Listado;
import com.example.spring02.service.ListadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "listado")
public class ListadoApi {
    @Autowired
    ListadoService listadoService;

    @GetMapping
    public ResponseEntity<List<Listado>> findAll(){
        return ResponseEntity.ok(listadoService.findAll());
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Listado> findByDni(@PathVariable("dni") String dni){
        Listado listado = listadoService.findByDni(dni);

        if(listado == null){
            throw new ModeloNotFoundException("Persona no encontrado en el listado de aportantes");
        }

        return ResponseEntity.ok(listadoService.findByDni(dni));
    }
}
