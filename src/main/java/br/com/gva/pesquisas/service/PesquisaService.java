package br.com.gva.pesquisas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gva.pesquisas.model.dto.PesquisaInserirDTO;
import br.com.gva.pesquisas.model.dto.PesquisaSalvaDTO;
import br.com.gva.pesquisas.model.entidade.Pesquisa;
import br.com.gva.pesquisas.repository.PesquisaRepository;

@Service
public class PesquisaService {

    @Autowired
    private PesquisaRepository pesquisaRepository;

    public PesquisaSalvaDTO salvar(PesquisaInserirDTO dto){
        return pesquisa2PesquisaSalvaDTO(pesquisaRepository.save(dto2Pesquisa(dto)));
    }

    private Pesquisa dto2Pesquisa(PesquisaInserirDTO dto){
        return Pesquisa.builder()
            .nome(dto.getNome())
            .email(dto.getEmail())
            .sexo(dto.getSexo())
            .estadoCivil(dto.getEstadoCivil())
            .generoFilmes(dto.getGeneroFilmes())
            .build();
    }

    private PesquisaSalvaDTO pesquisa2PesquisaSalvaDTO(Pesquisa pesquisa) {
        return PesquisaSalvaDTO.builder()
            .id(pesquisa.getId())
            .sexo(pesquisa.getSexo())
            .estadoCivil(pesquisa.getEstadoCivil())
            .generoFilmes(pesquisa.getGeneroFilmes())
            .build();
    }
    
}

