package com.abc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.abc.bean.Depart;

@RestController
@RequestMapping("/consumer/depart")
public class DepartController {
    @Autowired
    private RestTemplate template;

    @PostMapping("/save")
    public boolean saveHandle(@RequestBody Depart depart) {
        String url = "http://localhost:8081/provider/depart/save";
        return template.postForObject(url, depart, Boolean.class);
    }

    @DeleteMapping("/del/{id}")
    public void deleteHandle(@PathVariable("id") int id) {
        String url = "http://localhost:8081/provider/depart/del" + id;
        template.delete(url);
    }

    @PutMapping("/update")
    public void updateHandle(@RequestBody Depart depart) {
        String url = "http://localhost:8081/provider/depart/update";
        template.put(url, depart);
    }

    @GetMapping("/get/{id}")
    public Depart getHandle(@PathVariable("id") int id) {
        String url = "http://localhost:8081/provider/depart/get/" + id;
        return template.getForObject(url, Depart.class);
    }

    @GetMapping("/list")
    public List<Depart> listHandle() {
        String url = "http://localhost:8081/provider/depart/list";
        return template.getForObject(url, List.class);
    }

}
