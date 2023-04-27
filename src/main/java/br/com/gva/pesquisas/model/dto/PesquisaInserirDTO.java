package br.com.gva.pesquisas.model.dto;

import java.util.List;

import br.com.gva.pesquisas.model.enums.EstadoCivil;
import br.com.gva.pesquisas.model.enums.GeneroFilme;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PesquisaInserirDTO {

    private Integer id;
    private String nome;
	private String email;
	private String sexo;
    private EstadoCivil estadoCivil;
    private List<GeneroFilme> generoFilmes;
    
}