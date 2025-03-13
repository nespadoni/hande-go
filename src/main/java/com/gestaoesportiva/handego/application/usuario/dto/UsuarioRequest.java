package com.gestaoesportiva.handego.application.usuario.dto;

import com.gestaoesportiva.handego.domain.enumeration.Role;

public record UsuarioRequest(
        String nome,
        String email,
        String senha,
        String telefone,
        Role role,
        String cpf,
        String cidade,
        String estado
) {
}
