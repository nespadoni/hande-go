package com.gestaoesportiva.handego.application.campeonato.dto;

import com.gestaoesportiva.handego.application.campeonato.entity.Campeonato;
import com.gestaoesportiva.handego.application.federacao.entity.Federacao;

public record CampeonatoResponse(
        Long id,
        String nome,
        String descricao,
        String dataInicio,
        String dataFim,
        String local,
        String cidade,
        String estado,
        Federacao federacao,
        boolean ativo
) {

    public CampeonatoResponse(Campeonato campeonato) {
        this(
                campeonato.getId(),
                campeonato.getNome(),
                campeonato.getDescricao(),
                campeonato.getDataInicio(),
                campeonato.getDataFim(),
                campeonato.getLocal(),
                campeonato.getCidade(),
                campeonato.getEstado(),
                campeonato.getFederacao(),
                campeonato.isAtivo()
        );
    }
}
