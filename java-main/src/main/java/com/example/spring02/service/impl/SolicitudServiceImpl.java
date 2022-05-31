package com.example.spring02.service.impl;

import com.example.spring02.model.Solicitud;
import com.example.spring02.repository.SolicitudRepository;
import com.example.spring02.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudServiceImpl implements SolicitudService {
    @Autowired
    SolicitudRepository solicitudRepository;

    @Override
    public List<Solicitud> findAll() {
        return solicitudRepository.findAll();
    }

    @Override
    public Solicitud create(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    @Override
    public Solicitud update(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    @Override
    public void delete(long id) {
        solicitudRepository.deleteById(id);
    }

    @Override
    public Solicitud findById(long id) {
        Optional<Solicitud> op =  solicitudRepository.findById(id);
        return op.isPresent() ? op.get() : new Solicitud();
    }

    @Override
    public Solicitud findByDni(String dni){
        return solicitudRepository.findByDni(dni);
    }
}