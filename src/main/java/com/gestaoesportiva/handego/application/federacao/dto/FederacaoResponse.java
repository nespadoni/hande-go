package com.gestaoesportiva.handego.application.federacao.dto;

import com.gestaoesportiva.handego.application.federacao.entity.Federacao;

public record FederacaoResponse(
        Long id,
        String nome,
        String sigla,
        String email,
        String telefone,
        String estado,
        boolean ativo

) {

    public FederacaoResponse(Federacao federacao) {
        this(federacao.getId(), federacao.getNome(), federacao.getSigla(), federacao.getEmail(), federacao.getTelefone(), federacao.getEstado(), federacao.getAtivo());
    }
}
