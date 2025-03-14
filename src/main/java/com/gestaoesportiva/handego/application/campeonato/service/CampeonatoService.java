package com.gestaoesportiva.handego.application.campeonato.service;

import com.gestaoesportiva.handego.application.campeonato.dto.CampeonatoRequest;
import com.gestaoesportiva.handego.application.campeonato.dto.CampeonatoResponse;
import com.gestaoesportiva.handego.application.campeonato.dto.CampeonatoUpdate;
import com.gestaoesportiva.handego.application.campeonato.entity.Campeonato;
import com.gestaoesportiva.handego.application.campeonato.repository.CampeonatoRepository;
import com.gestaoesportiva.handego.application.federacao.dto.FederacaoRequest;
import com.gestaoesportiva.handego.application.federacao.entity.Federacao;
import com.gestaoesportiva.handego.application.federacao.repository.FederacaoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CampeonatoService {

    private final CampeonatoRepository campeonatoRepository;
    private final FederacaoRepository federacaoRepository;

    public CampeonatoService(CampeonatoRepository campeonatoRepository, FederacaoRepository federacaoRepository) {
        this.campeonatoRepository = campeonatoRepository;
        this.federacaoRepository = federacaoRepository;
    }

    public Campeonato create(CampeonatoRequest dados) {
        Campeonato campeonato = new Campeonato(dados);
        Federacao federacao = federacaoRepository.findById(dados.federacaoId()).orElseThrow(() -> new RuntimeException("Federacao não encontrada"));
        campeonato.setFederacao(federacao);

        campeonatoRepository.save(campeonato);
        return campeonato;
    }

    public Page<CampeonatoResponse> findAll(Pageable paginacao) {
        Page<Campeonato> campeonatos = campeonatoRepository.findAll(paginacao);
        return campeonatos.map(CampeonatoResponse::new);
    }

    public CampeonatoResponse findById(Long id) {
        return campeonatoRepository.findById(id)
                .map(CampeonatoResponse::new).orElseThrow(() -> new RuntimeException("Campeonato não encontrado"));
    }

    public void update(Long id, CampeonatoUpdate dados) {
        Campeonato campeonato = campeonatoRepository.findById(id).orElseThrow(() -> new RuntimeException("Campeonato não encontrado"));
        campeonato.atualizar(dados);
        campeonatoRepository.save(campeonato);
    }

    public void inativar(Long id) {
        Campeonato campeonato = campeonatoRepository.findById(id).orElseThrow(() -> new RuntimeException("Campeonato não encontrado"));
        campeonato.setAtivo(false);
        campeonatoRepository.save(campeonato);
    }

    public void delete(Long id) {
        Campeonato campeonato = campeonatoRepository.findById(id).orElseThrow(() -> new RuntimeException("Campeonato não encontrado"));
        campeonatoRepository.deleteById(id);
    }

}
