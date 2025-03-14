package com.gestaoesportiva.handego.application.federacao.dto;

public record FederacaoUpdate(
        Long id,
        String nome,
        String sigla,
        String email,
        String senha,
        String telefone,
        String cnpj,
        String estado
) {
}
