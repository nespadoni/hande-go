package com.gestaoesportiva.handego.domain.model;

import com.gestaoesportiva.handego.application.campeonato.entity.Campeonato;
import com.gestaoesportiva.handego.application.partida.entity.Partida;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "rodadas")
public class Rodada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numeroRodada;

    @ManyToOne
    @JoinColumn(name = "campeonato_id")
    private Campeonato campeonato;

    @OneToMany(mappedBy = "rodada", cascade = CascadeType.ALL)
    private List<Partida> partidas;

    private LocalDate dataInicio;
    private LocalDate dataFim;

}
