package br.com.gva.pesquisas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gva.pesquisas.model.entidade.Pesquisa;
import br.com.gva.pesquisas.repository.PesquisaRepository;

@Service
public class PesquisaService {

    @Autowired
    private PesquisaRepository pesquisaRepository;

    public Pesquisa salvar(Pesquisa pesquisa){
        return pesquisaRepository.save(pesquisa);
    }
    
}