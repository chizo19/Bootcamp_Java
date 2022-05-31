package com.example.spring02.service.impl;

import com.example.spring02.model.Afp;
import com.example.spring02.repository.AfpRepository;
import com.example.spring02.service.AfpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AfpServiceImpl implements AfpService {
    @Autowired
    AfpRepository afpRepository;

    @Override
    public List<Afp> findAll(){
        return afpRepository.findAll();
    }

    @Override
    public Afp create(Afp afp) {
        return afpRepository.save(afp);
    }

    @Override
    public Afp update(Afp afp) {
        return afpRepository.save(afp);
    }

    @Override
    public void delete(long id) {
        afpRepository.deleteById(id);
    }

    @Override
    public Afp findById(long id) {
        Optional<Afp> op = afpRepository.findById(id);
        return op.isPresent() ? op.get() : new Afp();
    }

    @Override
    public Afp findByDesc(String desc) {
        return afpRepository.findByDesc(desc);
    }
}
