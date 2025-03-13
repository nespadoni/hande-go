package com.gestaoesportiva.handego.application.campeonato.entity;

import com.gestaoesportiva.handego.application.campeonato.dto.CampeonatoRequest;
import com.gestaoesportiva.handego.application.campeonato.dto.CampeonatoUpdate;
import com.gestaoesportiva.handego.application.federacao.entity.Federacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne
    private Federacao federacao;
    private boolean ativo;

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
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.dataInicio = dados.dataInicio();
        this.dataFim = dados.dataFim();
        this.local = dados.local();
        this.cidade = dados.cidade();
        this.estado = dados.estado();
        this.ativo = dados.ativo();
    }

}
