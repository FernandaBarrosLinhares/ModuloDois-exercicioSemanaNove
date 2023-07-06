package br.senai.lab365.demo.controller;


import br.senai.lab365.demo.dto.PetGetRequest;
import br.senai.lab365.demo.models.Pet;
import br.senai.lab365.demo.models.Tutor;
import br.senai.lab365.demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService service;

    @GetMapping
    public String buscaPets(@RequestParam(required = false) String especie,
                            @RequestParam(required = false) String raca) {
        if (especie != null && especie.length() > 0) {
            return "lista de pets da espécie: " + especie;
        } else {
            return "lista completa de pets";
        }
    }

    @GetMapping("/filtro-por-dto")
    public String buscaPetsParametersDTO(PetGetRequest params) {
        if (params != null && params.getEspecie() != null && params.getEspecie().length() > 0) {
            return "lista de pets da espécie: " + params.getEspecie();
        } else {
            return "lista completa de pets";
        }
    }

    @PostMapping
    public Pet cadastraPet(@RequestBody Pet novoPet) {
        return novoPet;
    }

    @GetMapping("/{idPet}")
    public String buscaPet(@PathVariable("idPet") int id) {
        return "este é um pet com id: " + id;
    }

    @PostMapping("/vacina")
    public String cadastraVacina() {
        return "vacina cadastrada";
    }

    @PutMapping("/{id}")
    public String atualizaPet() {
        return "pet atualizado";
    }

    @PatchMapping("/{idPet}")
    public void associaTutor(@PathVariable int idPet, @RequestBody Tutor tutor) {
        service.associaTutor(idPet, tutor);
    }

}
