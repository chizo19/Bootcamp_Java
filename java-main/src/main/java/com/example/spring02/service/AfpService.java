package com.example.spring02.service;

import com.example.spring02.model.Afp;
import java.util.List;

public interface AfpService {
    List<Afp> findAll();
    Afp create(Afp afp);
    Afp update(Afp afp);
    void delete(long id);
    Afp findById(long id);
    Afp findByDesc(String desc);
}
