package com.gestaoesportiva.handego.application.clube.dto;

public record ClubeUpdate(
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
