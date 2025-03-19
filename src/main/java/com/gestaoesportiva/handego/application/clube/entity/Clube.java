package com.gestaoesportiva.handego.application.clube.entity;

import com.gestaoesportiva.handego.application.campeonato.entity.Campeonato;
import com.gestaoesportiva.handego.application.clube.dto.ClubeRequest;
import com.gestaoesportiva.handego.application.clube.dto.ClubeUpdate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class Clube {

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

    @ManyToMany(mappedBy = "clubes")
    private List<Campeonato> campeonatos = new ArrayList<>();

    private Boolean ativo;


    public Clube(ClubeRequest dados) {
        this.nome = dados.nome();
        this.sigla = dados.sigla();
        this.email = dados.email();
        this.senha = dados.senha();
        this.telefone = dados.telefone();
        this.cnpj = dados.cnpj();
        this.estado = dados.estado();
        this.ativo = true;
    }

    public void update(ClubeUpdate dados) {
        if (dados.nome() != null) this.nome = dados.nome();
        if (dados.sigla() != null) this.sigla = dados.sigla();
        if (dados.email() != null) this.email = dados.email();
        if (dados.senha() != null) this.senha = dados.senha();
        if (dados.telefone() != null) this.telefone = dados.telefone();
        if (dados.cnpj() != null) this.cnpj = dados.cnpj();
        if (dados.estado() != null) this.estado = dados.estado();
    }
}
