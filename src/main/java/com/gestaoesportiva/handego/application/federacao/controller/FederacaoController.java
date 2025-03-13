package com.gestaoesportiva.handego.application.federacao.controller;

import com.gestaoesportiva.handego.application.federacao.dto.FederacaoRequest;
import com.gestaoesportiva.handego.application.federacao.dto.FederacaoUpdate;
import com.gestaoesportiva.handego.application.federacao.entity.Federacao;
import com.gestaoesportiva.handego.application.federacao.service.FederacaoService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/federacao")
public class FederacaoController {

    private final FederacaoService federacaoService;

    public FederacaoController(FederacaoService federacaoService) {
        this.federacaoService = federacaoService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody FederacaoRequest dados) {
        Federacao federacao = federacaoService.create(dados);
        return ResponseEntity.ok().body("O usuario "+ dados.nome() + " foi criado com sucesso");
    }

    @GetMapping
    public ResponseEntity<?> getAll(Pageable paginacao) {
        return ResponseEntity.ok().body(federacaoService.getAll(paginacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(federacaoService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody FederacaoUpdate dados) {
        Federacao federacao = federacaoService.getById(id);
        federacaoService.update(id, dados);
        return ResponseEntity.ok().body("O usuario "+ federacao.getNome() + " foi atualizado com sucesso");
    }

    @PutMapping("/{id}/inativar")
    public ResponseEntity<?> inative(@PathVariable Long id) {
        Federacao federacao = federacaoService.getById(id);
        federacaoService.inative(id);
        return ResponseEntity.ok().body("O usuario "+ federacao.getNome() + " foi inativado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Federacao federacao = federacaoService.getById(id);
        federacaoService.delete(id);
        return ResponseEntity.ok().body("O usuario "+ federacao.getNome() + " foi deletado com sucesso");
    }
}
