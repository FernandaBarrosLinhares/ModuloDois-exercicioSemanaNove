package br.senai.lab365.demospringboot.models;


import br.senai.lab365.demo.models.Tutor;
import br.senai.lab365.demo.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repository;

    public void cadastrar(Tutor tutor) {
        repository.cadastrar(tutor);
    }
}

