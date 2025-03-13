package com.gestaoesportiva.handego.application.federacao.service;

import com.gestaoesportiva.handego.application.federacao.dto.FederacaoRequest;
import com.gestaoesportiva.handego.application.federacao.dto.FederacaoUpdate;
import com.gestaoesportiva.handego.application.federacao.entity.Federacao;
import com.gestaoesportiva.handego.application.federacao.repository.FederacaoRepository;
import com.gestaoesportiva.handego.application.usuario.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FederacaoService {

    private final FederacaoRepository federacaoRepository;

    public FederacaoService(FederacaoRepository federacaoRepository) {
        this.federacaoRepository = federacaoRepository;
    }

    public Federacao create(FederacaoRequest dados) {
        Federacao federacao = new Federacao(dados);
        federacaoRepository.save(federacao);
        return federacao;
    }

    public Page<Federacao> getAll(Pageable paginacao) {
        return federacaoRepository.findAll(paginacao);
    }

    public Federacao getById(Long id) {
        return federacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Federação não encontrada"));
    }

    public Federacao update(Long id, FederacaoUpdate dados) {
        Federacao federacao = federacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Federação não encontrada"));
        federacao.atualizar(dados);
        federacaoRepository.save(federacao);
        return federacao;
    }

    public void inative(Long id) {
        Federacao federacao = federacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Federação não encontrada"));
        federacao.setAtivo(false);
        federacaoRepository.save(federacao);
    }

    public void delete(Long id) {
        Federacao federacao = federacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Federação não encontrada"));
        federacaoRepository.deleteById(id);
    }
}
