package com.gestaoesportiva.handego.domain.model;

import com.gestaoesportiva.handego.application.campeonato.entity.Campeonato;
import com.gestaoesportiva.handego.application.federacao.entity.Federacao;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class Regra {

    private Long id;
    private String descricao;

    @OneToMany
    @JoinColumn(name = "campeonato_id")
    private Campeonato campeonato;

    @ManyToOne
    @JoinColumn(name = "federacao_id")
    private Federacao federacao;

}
