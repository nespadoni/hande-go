package com.gestaoesportiva.handego.application.clube.controller;

import com.gestaoesportiva.handego.application.clube.dto.ClubeRequest;
import com.gestaoesportiva.handego.application.clube.dto.ClubeResponse;
import com.gestaoesportiva.handego.application.clube.dto.ClubeUpdate;
import com.gestaoesportiva.handego.application.clube.service.ClubeService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/clubes")
@RestController
public class ClubeController {

    private final ClubeService clubeService;

    public ClubeController(ClubeService clubeService) {
        this.clubeService = clubeService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid ClubeRequest dados) {
        clubeService.save(dados);
        return ResponseEntity.ok().body("Clube " + dados.nome() + " criado com sucesso");
    }

    @GetMapping
    public ResponseEntity<?> getAll(Pageable paginacao) {
        Page<ClubeResponse> clubes = clubeService.get(paginacao);
        return ResponseEntity.ok().body(clubes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        ClubeResponse clube = clubeService.findById(id);
        return ResponseEntity.ok().body(clube);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid ClubeUpdate dados) {
        clubeService.update(id, dados);
        return ResponseEntity.ok().body("Clube com Id " + id + "atualizado com sucesso");
    }

    @PutMapping("/{id}/inativar")
    public ResponseEntity<?> inativar(@PathVariable Long id) {
        clubeService.inativar(id);
        return ResponseEntity.ok().body("Clube com Id " + id + "inativado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        clubeService.delete(id);
        return ResponseEntity.ok().body("Clube com Id " + id + "deletado com sucesso");
    }
}
