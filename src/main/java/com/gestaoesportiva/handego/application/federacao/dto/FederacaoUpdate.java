package com.gestaoesportiva.handego.application.federacao.dto;

import com.gestaoesportiva.handego.domain.model.Atualizavel;

public record FederacaoUpdate(
        Long id,
        String nome,
        String email,
        String senha,
        String telefone,
        String cnpj,
        String estado
) implements Atualizavel {
}
