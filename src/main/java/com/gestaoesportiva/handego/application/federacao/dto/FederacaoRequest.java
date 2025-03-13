package com.gestaoesportiva.handego.application.federacao.dto;

public record FederacaoRequest(

        String nome,
        String email,
        String senha,
        String telefone,
        String cnpj,
        String estado
) {
}
