package br.com.gva.pesquisas.model.entidade;

import java.util.ArrayList;
import java.util.List;

import br.com.gva.pesquisas.model.GeneroFilme;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Pesquisa {

    @EqualsAndHashCode.Include
    private int id;
	private String nome;
	private String email;
	private String sexo;
	private String estadoCivil;
    private List<GeneroFilme> generoFilmes = new ArrayList<>();
}