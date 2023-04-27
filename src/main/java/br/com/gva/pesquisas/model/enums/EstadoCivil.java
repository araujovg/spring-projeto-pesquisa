package br.com.gva.pesquisas.model.enums;

import lombok.Getter;

public enum EstadoCivil {

    CASADO("Casado(a)"),
    SOLTEIRO("Sotleiro(a)"),
    VIUVO("Viúvo(a)"),
    DIVORCIADO("Divorciado(a)");

    @Getter
    private String descricao;

    EstadoCivil(String descricao){
        this.descricao = descricao;
    }
    
}