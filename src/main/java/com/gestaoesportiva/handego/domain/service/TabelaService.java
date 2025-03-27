package com.gestaoesportiva.handego.domain.service;

import com.gestaoesportiva.handego.application.clube.entity.Clube;
import com.gestaoesportiva.handego.application.clube.repository.ClubeRepository;
import com.gestaoesportiva.handego.application.partida.entity.Partida;
import com.gestaoesportiva.handego.application.partida.repository.PartidaRepository;
import com.gestaoesportiva.handego.domain.model.Rodada;
import com.gestaoesportiva.handego.domain.model.Tabela;
import com.gestaoesportiva.handego.domain.repository.RodadaRepository;
import com.gestaoesportiva.handego.domain.repository.TabelaRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TabelaService {

    private final TabelaRepository tabelaRepository;
    private final RodadaRepository rodadaRepository;
    private final PartidaRepository partidaRepository;
    private final ClubeRepository clubeRepository;

    public TabelaService(TabelaRepository tabelaRepository, RodadaRepository rodadaRepository, PartidaRepository partidaRepository, ClubeRepository clubeRepository) {
        this.tabelaRepository = tabelaRepository;
        this.rodadaRepository = rodadaRepository;
        this.partidaRepository = partidaRepository;
        this.clubeRepository = clubeRepository;
    }

    @Transactional
    public Tabela criarTabela(List<Long> clubeIds) {
        List<Clube> clubes = clubeRepository.findAllById(clubeIds);

        if (clubes.size() < 2) {
            throw new IllegalArgumentException("É necessário pelo menos 2 clubes para criar uma tabela.");
        }

        Tabela tabela = new Tabela();
        tabela.setTimes(new ArrayList<>(clubes));
        tabela.gerarRodadas();

        tabelaRepository.save(tabela);

        for (Rodada rodada : tabela.getRodadas()) {
            rodada.setTabela(tabela);
            rodadaRepository.save(rodada);

            for (Partida partida : rodada.getPartidas()) {
                partida.setRodada(rodada);
                partidaRepository.save(partida);
            }
        }

        return tabela;
    }

    public List<Tabela> listarTabelas() {
        return tabelaRepository.findAll();
    }

    public Optional<Tabela> buscarTabelaPorId(Long id) {
        return tabelaRepository.findById(id);
    }
}
