package br.com.gva.pesquisas.model;

import lombok.Getter;
import lombok.Setter;

public enum GeneroFilme {

    FICCAO(1, "Ficção"),
    ACAO(2, "Ação"),
    TERROR(3, "Terror"),
    ROMANCE(4, "Romance"),
    COMEDIA(5, "Comédia"),
    ANIMACAO(6, "Animação");

    @Getter @Setter private int id;
    @Getter @Setter private String descricao;

    GeneroFilme(int id, String descricao){
        this.id = id;
        this.descricao = descricao;
    }
    
}