package com.gestaoesportiva.handego.application.clube.dto;

public record ClubeRequest(
        String nome,
        String sigla,
        String email,
        String senha,
        String telefone,
        String cnpj,
        String estado
) {
}
