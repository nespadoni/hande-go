package com.gestaoesportiva.handego.application.campeonato.service;

import com.gestaoesportiva.handego.application.campeonato.dto.CampeonatoRequest;
import com.gestaoesportiva.handego.application.campeonato.dto.CampeonatoResponse;
import com.gestaoesportiva.handego.application.campeonato.dto.CampeonatoUpdate;
import com.gestaoesportiva.handego.application.campeonato.entity.Campeonato;
import com.gestaoesportiva.handego.application.campeonato.repository.CampeonatoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CampeonatoService {

    private final CampeonatoRepository campeonatoRepository;

    public CampeonatoService(CampeonatoRepository campeonatoRepository) {
        this.campeonatoRepository = campeonatoRepository;
    }

    public Campeonato create(CampeonatoRequest dados) {
        Campeonato campeonato = new Campeonato(dados);
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
