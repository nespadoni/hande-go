//package com.gestaoesportiva.handego.domain.model;
//
//import com.gestaoesportiva.handego.application.campeonato.entity.Campeonato;
//import com.gestaoesportiva.handego.application.clube.entity.Clube;
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "classificacoes")
//public class Classificacao {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "campeonato_id")
//    private Campeonato campeonato;
//
//    @ManyToOne
//    @JoinColumn(table = "clube", name = "clube_id")
//    private Clube clube;
//
//    private int pontos = 0;
//    private int jogos = 0;
//    private int vitorias = 0;
//    private int empates = 0;
//    private int derrotas = 0;
//    private int golsPro = 0;
//    private int golsContra = 0;
//    private int saldoGols = 0;
//
//    public void atualizarClassificacao(int golsFeitos, int golsSofridos) {
//        this.jogos++;
//
//        if (golsPro > golsContra) {
//            this.vitorias++;
//            this.pontos+=3;
//        } else if (golsFeitos == golsSofridos) {
//            this.empates++;
//            this.pontos+=1;
//        } else {
//            this.derrotas++;
//        }
//
//        this.golsPro += golsFeitos;
//        this.golsContra += golsSofridos;
//        this.saldoGols = this.golsPro - this.golsContra;
//    }
//}
