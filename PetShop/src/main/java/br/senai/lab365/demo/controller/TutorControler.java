package br.senai.lab365.demo.controller;

import br.senai.lab365.demo.models.Tutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tutores")
public class TutorControler {
    @Autowired
    private     br.senai.lab365.demospringboot.models.TutorService service;

    @PostMapping
    public void cadastrar(@RequestBody Tutor tutor) {


        service.cadastrar(tutor);
    }
}
