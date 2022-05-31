package com.example.spring02.service;

import com.example.spring02.model.Listado;
import java.util.List;

public interface ListadoService {
    List<Listado> findAll();
    Listado findByDni(String dni);
}
