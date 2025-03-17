package com.gestaoesportiva.handego.application.campeonato.entity;

import com.gestaoesportiva.handego.application.campeonato.dto.CampeonatoRequest;
import com.gestaoesportiva.handego.application.campeonato.dto.CampeonatoUpdate;
import com.gestaoesportiva.handego.application.clube.entity.Clube;
import com.gestaoesportiva.handego.application.federacao.entity.Federacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "campeonato")
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String dataInicio;
    private String dataFim;
    private String local;
    private String cidade;
    private String estado;

    @ManyToMany
    @JoinTable(
            name = "campeonato_clube",
            joinColumns = @JoinColumn(name = "campeonato_id"),
            inverseJoinColumns = @JoinColumn(name = "clube_id")
    )
    private Set<Clube> clubes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "federacao_id")
    private Federacao federacao;
    private Boolean ativo;

    public Campeonato(CampeonatoRequest dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.dataInicio = dados.dataInicio();
        this.dataFim = dados.dataFim();
        this.local = dados.local();
        this.cidade = dados.cidade();
        this.estado = dados.estado();
        this.ativo = true;
    }

    public void atualizar(CampeonatoUpdate dados) {
        if (dados.nome() != null) this.nome = dados.nome();
        if (dados.descricao() != null) this.descricao = dados.descricao();
        if (dados.dataInicio() != null) this.dataInicio = dados.dataInicio();
        if (dados.dataFim() != null) this.dataFim = dados.dataFim();
        if (dados.local() != null) this.local = dados.local();
        if (dados.cidade() != null) this.cidade = dados.cidade();
        if (dados.estado() != null) this.estado = dados.estado();
        if (dados.federacaoId() != null) this.federacao = new Federacao();
    }

}
