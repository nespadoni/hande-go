package com.gestaoesportiva.handego.application.dto;

import com.gestaoesportiva.handego.domain.entity.Usuario;
import com.gestaoesportiva.handego.domain.enumeration.Role;

public record UsuarioResponse(
        Long id,
        String nome,
        String email,
        String telefone,
        Role role,
        String cpf,
        String cidade,
        String estado,
        Boolean ativo
) {

    public UsuarioResponse(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTelefone(), usuario.getRole(), usuario.getCpf(), usuario.getCidade(), usuario.getEstado(), usuario.isAtivo());
    }
}
