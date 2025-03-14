package com.gestaoesportiva.handego.application.usuario.service;

import com.gestaoesportiva.handego.application.usuario.dto.UsuarioRequest;
import com.gestaoesportiva.handego.application.usuario.dto.UsuarioResponse;
import com.gestaoesportiva.handego.application.usuario.dto.UsuarioUpdate;
import com.gestaoesportiva.handego.application.usuario.entity.Usuario;
import com.gestaoesportiva.handego.application.usuario.repository.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario create(UsuarioRequest dados) {
        Usuario usuario = new Usuario(dados);
        usuarioRepository.save(usuario);
        return usuario;
    }

    public Page<UsuarioResponse> getAll(Pageable paginacao) {
        Page<Usuario> usuarios = usuarioRepository.findAll(paginacao);
        return usuarios.map(UsuarioResponse::new);
    }

    public UsuarioResponse getById(Long id) {
        return usuarioRepository.findById(id)
                .map(UsuarioResponse::new).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public void update(Long id, UsuarioUpdate dados) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuario.atualizar(dados);
        String nome = usuario.getNome();
        usuarioRepository.save(usuario);
    }

    public void inative(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuario.setAtivo(false);
        usuarioRepository.save(usuario);
    }

    public void delete(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuarioRepository.deleteById(id);
    }
}
