package com.gestaoesportiva.handego.application.campeonato.dto;

import com.gestaoesportiva.handego.application.campeonato.entity.Campeonato;

public record CampeonatoResponseClube(
        Long id,
        String nome
) {
    public CampeonatoResponseClube(Campeonato campeonato) {
        this(campeonato.getId(), campeonato.getNome());
    }
}
