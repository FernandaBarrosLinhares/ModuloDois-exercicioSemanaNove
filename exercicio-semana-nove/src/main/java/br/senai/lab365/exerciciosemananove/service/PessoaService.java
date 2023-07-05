package br.senai.lab365.exerciciosemananove.service;

import br.senai.lab365.exerciciosemananove.entity.PessoaEntity;
import br.senai.lab365.exerciciosemananove.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private PessoaRepository repository;

    public PessoaService(PessoaRepository repository){
        this.repository = repository;
    }
   public PessoaEntity savePessoa(PessoaEntity p){
        PessoaEntity pessoa = this.repository.save(p);
        return pessoa;
    }

    public List<PessoaEntity> buscarPessoas(String filter) {
        if(filter == null || filter.isEmpty()){
            return this.repository.findAllFilter(filter);

    }else {
            return this.repository.findAll();
        }
    }
   public PessoaEntity buscarPessoa(Long id){

       Optional<PessoaEntity> byId = this.repository.findById(id);
               if(byId.isPresent()){
                   return byId.get();
       }
       return null;
    }
    public List<PessoaEntity> buscarTodosStatusTrue(){
        return this.repository.findByStatus(true);
    }
    public PessoaEntity atualizarPessoa(PessoaEntity p) {
        if (p.getId() != null && p.getId() > 0) {
            Optional<PessoaEntity> byId = this.repository.findById(p.getId());
            if (byId.isPresent()) {
                return this.repository.save(p);
            }
        }

        return null;
    }
    public void ExcluirPessoa(Long id){
        this.repository.deleteById(id);
    }
}
