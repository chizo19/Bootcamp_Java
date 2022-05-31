package com.example.spring02.service.impl;

import com.example.spring02.model.Listado;
import com.example.spring02.repository.ListadoRepository;
import com.example.spring02.service.ListadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ListadoServiceImpl implements ListadoService {
    @Autowired
    ListadoRepository listadoRepository;

    @Override
    public List<Listado> findAll() {
        return listadoRepository.findAll();
    }

    @Override
    public Listado findByDni(String dni) {
        return listadoRepository.findByDni(dni);
    }
}
