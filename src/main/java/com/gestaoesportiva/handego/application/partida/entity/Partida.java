package com.gestaoesportiva.handego.application.partida.entity;

import com.gestaoesportiva.handego.application.clube.entity.Clube;
import com.gestaoesportiva.handego.domain.enums.StatusPartida;
import com.gestaoesportiva.handego.domain.model.Rodada;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "partidas")
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "time_casa_id", nullable = false)
    private Clube timeCasa;

    @ManyToOne
    @JoinColumn(name = "time_visitante_id", nullable = false)
    private Clube timeVisitante;

    @ManyToOne
    @JoinColumn(name = "rodada_id", nullable = false)
    private Rodada rodada;

    private Integer golsCasa = 0;
    private Integer golsVisitante = 0;

    @Enumerated(EnumType.STRING)
    private StatusPartida status = StatusPartida.NAO_REALIZADO;

}
