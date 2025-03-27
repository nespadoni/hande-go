package com.gestaoesportiva.handego.domain.model;

import com.gestaoesportiva.handego.application.campeonato.entity.Campeonato;
import com.gestaoesportiva.handego.application.partida.entity.Partida;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "rodada")
public class Rodada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tabelas_id")
    private Tabela tabela;

    private Integer numeroRodada;

    @OneToMany(mappedBy = "rodada", cascade = CascadeType.ALL)
    private List<Partida> partidas = new ArrayList<>();

    private LocalDate dataInicio;
    private LocalDate dataFim;
}
