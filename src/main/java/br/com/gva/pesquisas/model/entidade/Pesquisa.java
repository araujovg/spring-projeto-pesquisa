package br.com.gva.pesquisas.model.entidade;

import java.util.ArrayList;
import java.util.List;

import br.com.gva.pesquisas.model.GeneroFilme;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
@Entity
public class Pesquisa {

    @EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    private Integer id;

	private String nome;
	private String email;
	private String sexo;
	private String estadoCivil;


	@ElementCollection(fetch = FetchType.LAZY, targetClass = GeneroFilme.class)
	@JoinTable(name = "pesquisa_genero_filme", joinColumns =
		@JoinColumn(name = "pesquisa_id")
	)
	@Column(name = "tipo_genero", nullable = false)
    private List<GeneroFilme> generoFilmes = new ArrayList<>();
}