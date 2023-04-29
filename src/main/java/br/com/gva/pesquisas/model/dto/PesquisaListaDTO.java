package br.com.gva.pesquisas.model.dto;

import java.util.List;

import br.com.gva.pesquisas.model.enums.EstadoCivil;
import br.com.gva.pesquisas.model.enums.GeneroFilme;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PesquisaListaDTO {

    private Integer id;
    private String nome;
	private String sexo;
    private EstadoCivil estadoCivil;
    private List<GeneroFilme> generoFilmes;

}
