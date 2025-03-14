package com.gestaoesportiva.handego.application.campeonato.dto;

import com.gestaoesportiva.handego.application.campeonato.entity.Campeonato;
import com.gestaoesportiva.handego.application.federacao.dto.FederacaoResponse;
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
        FederacaoResponse federacao,
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
                campeonato.getFederacao() != null ? new FederacaoResponse(campeonato.getFederacao()) : null,
                campeonato.getAtivo()
        );
    }
}
