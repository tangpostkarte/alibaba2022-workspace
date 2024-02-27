package com.abc.controller;

import com.abc.bean.Depart;
import com.abc.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/depart")
@RestController
public class DepartController {

    @Autowired
    private DepartService service;

    @PostMapping("/")
    public boolean saveHandle(@RequestBody Depart depart) {
        return service.saveDepart(depart);
    }
}
