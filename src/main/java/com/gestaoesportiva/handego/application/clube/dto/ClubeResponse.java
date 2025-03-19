package com.gestaoesportiva.handego.application.clube.dto;

import com.gestaoesportiva.handego.application.campeonato.dto.CampeonatoResponseClube;
import com.gestaoesportiva.handego.application.clube.entity.Clube;

import java.util.List;

public record ClubeResponse(
        Long id,
        String nome,
        String sigla,
        String email,
        String telefone,
        String cnpj,
        String estado,
        List<CampeonatoResponseClube> campeonato,
        Boolean ativo
) {

    public ClubeResponse(Clube clube) {
        this(clube.getId(), clube.getNome(), clube.getSigla(), clube.getEmail(), clube.getTelefone(), clube.getCnpj(), clube.getEstado(),
                clube.getCampeonatos().stream().map(CampeonatoResponseClube::new).toList(),
                clube.getAtivo());
    }
}
