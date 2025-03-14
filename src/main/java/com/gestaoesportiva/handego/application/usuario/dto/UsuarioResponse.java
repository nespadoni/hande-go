package com.gestaoesportiva.handego.application.usuario.dto;

import com.gestaoesportiva.handego.application.usuario.entity.Usuario;
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
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getTelefone(), usuario.getRole(), usuario.getCpf(), usuario.getCidade(), usuario.getEstado(), usuario.getAtivo());
    }
}
