package br.com.gva.pesquisas.model.entidade;

import java.util.ArrayList;
import java.util.List;

import br.com.gva.pesquisas.model.enums.EstadoCivil;
import br.com.gva.pesquisas.model.enums.GeneroFilme;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Builder
@Entity
public class Pesquisa {

	@Getter @Setter
    @EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    private Integer id;

	@Getter @Setter
	private String nome;

	@Getter @Setter
	private String email;

	@Getter @Setter
	private String sexo;

	@Getter @Setter
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;

	@Getter @Setter
	@ElementCollection(fetch = FetchType.LAZY, targetClass = GeneroFilme.class)
	@JoinTable(name = "pesquisa_genero_filme", joinColumns =
		@JoinColumn(name = "pesquisa_id")
	)
	@Column(name = "tipo_genero", nullable = false)
    private List<GeneroFilme> generoFilmes = new ArrayList<>();
}