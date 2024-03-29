package com.abc.service.impl;

import com.abc.bean.Depart;
import com.abc.repository.DepartRepository;
import com.abc.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    private DepartRepository repository;

    @Override
    public boolean saveDepart(Depart depart) {
        Depart obj = repository.save(depart);
        if (obj != null) {
            return  true;
        }
        return false;
    }

    @Override
    public boolean removeDepartById(int id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override
    public boolean modifyDepart(Depart depart) {
        Depart obj = repository.save(depart);
        if (obj != null) {
            return  true;
        }
        return false;
    }

    @Override
    public Depart getDepartById(int id) {
        if (repository.existsById(id)) {
            return repository.getReferenceById(id);
        }

        Depart depart = new Depart();
        depart.setName("no this depart");

        return null;
    }

    @Override
    public List<Depart> listAllDeparts() {
        return repository.findAll();
    }
}
