package br.com.gva.pesquisas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.gva.pesquisas.model.entidade.Pesquisa;
import br.com.gva.pesquisas.model.enums.EstadoCivil;
import br.com.gva.pesquisas.model.enums.GeneroFilme;
import br.com.gva.pesquisas.repository.PesquisaRepository;

@SpringBootApplication
public class PesquisasApplication implements CommandLineRunner {

	@Autowired
	private PesquisaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(PesquisasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		var p1 = Pesquisa.builder()
				.nome("Bruce")
				.email("bruce@wayneenterprises.com")
				.sexo("masculino")
				.estadoCivil(EstadoCivil.SOLTEIRO)
				.generoFilmes(List.of(GeneroFilme.ACAO, GeneroFilme.FICCAO))
				.build();

		var p2 = Pesquisa.builder()
				.nome("Marta")
				.email("marta@wayneenterprises.com")
				.sexo("feminino")
				.estadoCivil(EstadoCivil.VIUVO)
				.generoFilmes(List.of(GeneroFilme.ROMANCE, GeneroFilme.FICCAO))
				.build();

		repository.saveAll(List.of(p1, p2));
	}

}
