package com.gestaoesportiva.handego.application.federacao.entity;

import com.gestaoesportiva.handego.application.federacao.dto.FederacaoRequest;
import com.gestaoesportiva.handego.application.federacao.dto.FederacaoUpdate;
import com.gestaoesportiva.handego.application.usuario.entity.Usuario;
import com.gestaoesportiva.handego.domain.model.EntidadeBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "federacao")
public class Federacao extends EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String cnpj;
    private String estado;

    private boolean ativo;

    public Federacao(FederacaoRequest dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
        this.telefone = dados.telefone();
        this.cnpj = dados.cnpj();
        this.estado = dados.estado();
        this.ativo = true;
    }

    public void atualizar(FederacaoUpdate dados) {
        atualizarBase(dados);
        if (dados.cnpj() != null) this.cnpj = dados.cnpj();
    }
}
