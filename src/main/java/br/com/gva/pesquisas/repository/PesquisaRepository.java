package br.com.gva.pesquisas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gva.pesquisas.model.entidade.Pesquisa;

@Repository
public interface PesquisaRepository extends JpaRepository<Pesquisa, Integer>{
    
}