package br.senai.lab365.exerciciosemananove.repository;

import br.senai.lab365.exerciciosemananove.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity,Long>{

    List<PessoaEntity> findByStatus(boolean status);
    void deleteByStatus(boolean status);

    @Query(value = "select + from pessoa where name like %:s% or email like %:s%", nativeQuery = true)
    List<PessoaEntity>findAllFilter(String s);
}
