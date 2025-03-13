package com.gestaoesportiva.handego.application.campeonato.dto;

public record CampeonatoRequest(
        String nome,
        String descricao,
        String dataInicio,
        String dataFim,
        String local,
        String cidade,
        String estado,
        Long federacaoId

) {
}
