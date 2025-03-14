package com.gestaoesportiva.handego.application.federacao.entity;

import com.gestaoesportiva.handego.application.federacao.dto.FederacaoRequest;
import com.gestaoesportiva.handego.application.federacao.dto.FederacaoUpdate;
import com.gestaoesportiva.handego.domain.model.Regra;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "federacao")
public class Federacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sigla;
    private String email;
    private String senha;
    private String telefone;
    private String cnpj;
    private String estado;

    @OneToMany(mappedBy = "federacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Regra> regras = new ArrayList<>();

    private Boolean ativo;

    public Federacao(FederacaoRequest dados) {
        this.nome = dados.nome();
        this.sigla = dados.sigla();
        this.email = dados.email();
        this.senha = dados.senha();
        this.telefone = dados.telefone();
        this.cnpj = dados.cnpj();
        this.estado = dados.estado();
        this.ativo = true;
    }

    public void atualizar(FederacaoUpdate dados) {
        if (dados.nome() != null) this.nome = dados.nome();
        if (dados.sigla() != null) this.sigla = dados.sigla();
        if (dados.email() != null) this.email = dados.email();
        if (dados.senha() != null) this.senha = dados.senha();
        if (dados.telefone() != null) this.telefone = dados.telefone();
        if (dados.cnpj() != null) this.cnpj = dados.cnpj();
        if (dados.estado() != null) this.estado = dados.estado();
    }
}
