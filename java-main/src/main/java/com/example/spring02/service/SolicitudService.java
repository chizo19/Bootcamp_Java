package com.example.spring02.service;

import com.example.spring02.model.Solicitud;
import java.util.List;

public interface SolicitudService {
    List<Solicitud> findAll();
    Solicitud create(Solicitud solicitud);
    Solicitud update(Solicitud solicitud);
    void delete(long id);
    Solicitud findById(long id);
    Solicitud findByDni(String dni);
}
