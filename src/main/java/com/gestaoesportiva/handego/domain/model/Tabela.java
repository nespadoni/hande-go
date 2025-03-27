package com.gestaoesportiva.handego.domain.model;

import com.gestaoesportiva.handego.application.clube.entity.Clube;
import com.gestaoesportiva.handego.application.partida.entity.Partida;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(name = "tabelas")
public class Tabela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "tabela_clubes",
            joinColumns = @JoinColumn(name = "tabela_id"),
            inverseJoinColumns = @JoinColumn(name = "clube_id")
    )
    private ArrayList<Clube> times = new ArrayList<>();

    @OneToMany(mappedBy = "tabela", cascade = CascadeType.ALL)
    private List<Rodada> rodadas = new ArrayList<>();

    public void adicionarTimes(Clube clube) {
        times.add(clube);
    }

    public void gerarRodadas() {
        List<Clube> listaTimes = new ArrayList<>(times);

        if (listaTimes.size() % 2 != 0) {
            Clube descanso = new Clube();
            descanso.setNome("Descanso");
            listaTimes.add(descanso);
        }

        int numeroTimes = listaTimes.size();
        int numeroRodadas = numeroTimes - 1;

        for (int rodadaIndex = 0; rodadaIndex < numeroRodadas; rodadaIndex++) {
            Rodada rodada = new Rodada();
            rodada.setTabela(this);

            for (int i = 0; i < numeroTimes / 2; i++) {
                Clube time1 = listaTimes.get(i);
                Clube time2 = listaTimes.get(numeroTimes - 1 - i);

                if (!time1.getNome().equals("Descanso") && !time2.getNome().equals("Descanso")) {
                    Partida partida = new Partida();
                    partida.setTimeCasa(time1);
                    partida.setTimeVisitante(time2);
                    partida.setRodada(rodada);
                    rodada.getPartidas().add(partida);
                }
            }

            rodadas.add(rodada);

            Clube timeRemovido = listaTimes.remove(1);
            listaTimes.add(timeRemovido);
        }
    }
}
