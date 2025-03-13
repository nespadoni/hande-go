package com.gestaoesportiva.handego.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class EntidadeBase {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String estado;
    private boolean ativo;

    public void atualizarBase(Atualizavel dados) {
        if (dados.id() != null) this.id = dados.id();
        if (dados.nome() != null) this.nome = dados.nome();
        if (dados.email() != null) this.email = dados.email();
        if (dados.senha() != null) this.senha = dados.senha();
        if (dados.telefone() != null) this.telefone = dados.telefone();
        if (dados.estado() != null) this.estado = dados.estado();
    }

}
