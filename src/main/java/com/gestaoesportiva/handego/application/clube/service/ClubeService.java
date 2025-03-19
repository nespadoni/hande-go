package com.gestaoesportiva.handego.application.clube.service;

import com.gestaoesportiva.handego.application.clube.dto.ClubeRequest;
import com.gestaoesportiva.handego.application.clube.dto.ClubeResponse;
import com.gestaoesportiva.handego.application.clube.dto.ClubeUpdate;
import com.gestaoesportiva.handego.application.clube.entity.Clube;
import com.gestaoesportiva.handego.application.clube.repository.ClubeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClubeService {

    private final ClubeRepository clubeRepository;

    public ClubeService(ClubeRepository clubeRepository) {
        this.clubeRepository = clubeRepository;
    }

    public void save(ClubeRequest dados) {
        Clube clube = new Clube(dados);
        clubeRepository.save(clube);
    }

    public Page<ClubeResponse> get(Pageable pageable) {
        Page<Clube> clubes = clubeRepository.findAll(pageable);
        return clubes.map(ClubeResponse::new);
    }

    public ClubeResponse findById(Long id) {
        return clubeRepository.findById(id).map(ClubeResponse::new).orElseThrow(() -> new RuntimeException("Clube não encontrado"));
    }

    public void update(Long id, ClubeUpdate dados) {
        Clube clube = clubeRepository.findById(id).orElseThrow(() -> new RuntimeException("Clube não encontrado"));
        clube.update(dados);
        clubeRepository.save(clube);
    }

    public void inativar(Long id) {
        Clube clube = clubeRepository.findById(id).orElseThrow(() -> new RuntimeException("Clube não encontrado"));
        clube.setAtivo(false);
    }

    public void delete(Long id) {
        Clube clube = clubeRepository.findById(id).orElseThrow(() -> new RuntimeException("Clube não encontrado"));
        clubeRepository.deleteById(id);
    }
}
