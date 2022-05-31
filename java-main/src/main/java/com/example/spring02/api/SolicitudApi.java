package com.example.spring02.api;

import com.example.spring02.exception.ModeloNotFoundException;
import com.example.spring02.model.Listado;
import com.example.spring02.model.Solicitud;
import com.example.spring02.service.ListadoService;
import com.example.spring02.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(value = "solicitud")
public class SolicitudApi {
    @Autowired
    SolicitudService solicitudService;
    @Autowired
    ListadoService listadoService;

    @GetMapping
    public ResponseEntity<List<Solicitud>> findAll(){
        return ResponseEntity.ok(solicitudService.findAll());
    }

    @PostMapping
    public ResponseEntity<Solicitud> create(@Valid @RequestBody Solicitud solicitud){
        Solicitud find = solicitudService.findByDni(solicitud.getDni());

        if(find != null){
            throw new ModeloNotFoundException("El DNI ya cuenta con una solicitud registrada");
        }

        Listado findL = listadoService.findByDni(solicitud.getDni());

        if(findL == null){
            throw new ModeloNotFoundException("El DNI ingresado no tiene aportes registrados");
        }

        Double minimoRetiro = findL.getMontoRetiro() / 2;

        if(solicitud.getMonto() > findL.getMontoRetiro()){
            throw new ModeloNotFoundException("No se puede registrar la solicitud. Monto mayor que el permitido");
        }

        if(solicitud.getMonto() < minimoRetiro){
            throw new ModeloNotFoundException("Monto mínimo no cubierto por favor revise el monto mínimo a retirar");
        }

        String afp1 = findL.getAfp().toLowerCase();
        String afp2 = solicitud.getAfp();

        if(!afp1.contains(afp2)){
            throw new ModeloNotFoundException("La AFP no pertenece a la persona");
        }

        Solicitud solicitudResponse = solicitudService.create(solicitud);
        return new ResponseEntity<>(solicitudResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Solicitud> update(@Valid @RequestBody Solicitud solicitud){
        Solicitud find = solicitudService.findByDni(solicitud.getDni());

        if(find != null){
            if(find.getId() != solicitud.getId()){
                throw new ModeloNotFoundException("El DNI ingresado ya cuenta con una solicitud registrada.");
            }
        }
        else{
            throw new ModeloNotFoundException("El DNI no cuenta con una solicitud registrada.");
        }

        Listado findL12 = listadoService.findByDni(solicitud.getDni());

        if(findL12 == null){
            throw new ModeloNotFoundException("El DNI ingresado no tiene aportes registrados");
        }

        Double minimoRetiro = findL12.getMontoRetiro() / 2;

        if(solicitud.getMonto() > findL12.getMontoRetiro()){
            throw new ModeloNotFoundException("No se puede registrar la solicitud. Monto mayor que el permitido");
        }

        if(solicitud.getMonto() < minimoRetiro){
            throw new ModeloNotFoundException("Monto mínimo no cubierto por favor revise el monto mínimo a retirar");
        }

        String afp1 = findL12.getAfp().toLowerCase();
        String afp2 = solicitud.getAfp();

        if(!afp1.contains(afp2)){
            throw new ModeloNotFoundException("La AFP no pertenece a la persona");
        }

        return ResponseEntity.ok(solicitudService.update(solicitud));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solicitud> findById(@PathVariable("id") long id){
        Solicitud solicitud = solicitudService.findById(id);

        if(solicitud.getId() == 0){
            throw  new ModeloNotFoundException("Solicitud no encontrado");
        }
        return ResponseEntity.ok(solicitudService.findById(id));
    }

    @GetMapping("/find/{dni}")
    public ResponseEntity<Solicitud> findByDni(@PathVariable("dni") String dni){
        Solicitud solicitud = solicitudService.findByDni(dni);

        if(solicitud == null){
            throw new ModeloNotFoundException("Solicitud no encontrado");
        }

        return ResponseEntity.ok(solicitudService.findByDni(dni));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id){
        Solicitud solicitud = solicitudService.findById(id);
        if(solicitud.getId() == 0){
            throw  new ModeloNotFoundException("Solicitud no encontrado");
        }
        solicitudService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
