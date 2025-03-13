package com.gestaoesportiva.handego.application.usuario.controller;

import com.gestaoesportiva.handego.application.usuario.dto.UsuarioRequest;
import com.gestaoesportiva.handego.application.usuario.dto.UsuarioResponse;
import com.gestaoesportiva.handego.application.usuario.dto.UsuarioUpdate;
import com.gestaoesportiva.handego.application.usuario.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid UsuarioRequest dados) {
        usuarioService.create(dados);
        return ResponseEntity.ok().body("Usuário " + dados.nome() + " criado com sucesso");
    }

    @GetMapping
    public ResponseEntity<?> findAll(Pageable paginacao) {
        Page<UsuarioResponse> usuarios = usuarioService.getAll(paginacao);
        return ResponseEntity.ok().body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        UsuarioResponse usuarios = usuarioService.getById(id);
        return ResponseEntity.ok().body(usuarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioUpdate dados) {
        usuarioService.update(id, dados);
        return ResponseEntity.ok().body("Usuário do Id " + id +  " atualizado com sucesso");
    }

    @PutMapping("/{id}/inativar")
    public ResponseEntity<?> inativar(@PathVariable Long id) {
        usuarioService.inative(id);
        return ResponseEntity.ok().body("Usuário inativado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.ok().body("Usuário deletado com sucesso");
    }
}
