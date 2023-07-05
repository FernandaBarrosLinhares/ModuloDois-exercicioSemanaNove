package br.senai.lab365.exerciciosemananove.controller;

import br.senai.lab365.exerciciosemananove.entity.PessoaEntity;
import br.senai.lab365.exerciciosemananove.service.PessoaService;
import jakarta.annotation.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaControler {
    private PessoaService service;

    public PessoaControler(PessoaService service){

        this.service = service;
    }
    @PostMapping
    public PessoaEntity insert(@RequestBody PessoaEntity pessoa){
        return this.service.savePessoa(pessoa);
    }
   @GetMapping
    public List<PessoaEntity> buscarTodasPessoas(@Nullable @RequestParam String q){
        return this.service.buscarPessoas(q);

   }
   @GetMapping("/{id}")
   public PessoaEntity buscarPessoaPeloId(@PathVariable Long id){
    return this.service.buscarPessoa(id);

   }
   @GetMapping("/status")
   public List<PessoaEntity> buscarTodasPessoasStatusTrue(){
        return this.service.buscarTodosStatusTrue();
   }

   @PutMapping
    public PessoaEntity atualizarPessoa(@RequestBody PessoaEntity p){
        return this.service.atualizarPessoa(p);
   }
   @DeleteMapping("/{id}")
   public void ExcluirPessoa(@PathVariable Long id){
        this.service.ExcluirPessoa(id);

   }


}
