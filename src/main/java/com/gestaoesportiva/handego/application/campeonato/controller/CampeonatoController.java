package com.gestaoesportiva.handego.application.campeonato.controller;

import com.gestaoesportiva.handego.application.campeonato.dto.CampeonatoRequest;
import com.gestaoesportiva.handego.application.campeonato.dto.CampeonatoUpdate;
import com.gestaoesportiva.handego.application.campeonato.service.CampeonatoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/campeonato")
public class CampeonatoController {

    private final CampeonatoService campeonatoService;

    public CampeonatoController(CampeonatoService campeonatoService) {
        this.campeonatoService = campeonatoService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid CampeonatoRequest dados) {
        campeonatoService.create(dados);
        return ResponseEntity.ok().body("Campeonato " + dados.nome() + " criado com sucesso");
    }

    @GetMapping
    public ResponseEntity<?> findAll(Pageable paginacao) {
        campeonatoService.findAll(paginacao);
        return ResponseEntity.ok().body(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id, CampeonatoUpdate dados) {
        campeonatoService.findById(id);
        return ResponseEntity.ok().body("Campeonato " + dados.nome() + " encontrado");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, CampeonatoUpdate dados) {
        campeonatoService.update(id, dados);
        return ResponseEntity.ok().body("Campeonato " + dados.nome() + " atualizado com sucesso");
    }

    @PutMapping("/{id}/inativar")
    public ResponseEntity<?> inativar(@PathVariable Long id) {
        campeonatoService.inativar(id);
        return ResponseEntity.ok().body("Campeonato com Id " + id + "inativado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        campeonatoService.delete(id);
        return ResponseEntity.ok().body("Campeonato com Id " + id + "deletado com sucesso");
    }
}
