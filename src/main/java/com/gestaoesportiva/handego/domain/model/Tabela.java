//package com.gestaoesportiva.handego.domain.model;
//
//import com.gestaoesportiva.handego.application.clube.entity.Clube;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Table;
//import lombok.Data;
//
//import java.util.ArrayList;
//
//@Data
//@Entity
//@Table(name = "tabelas")
//public class Tabela {
//
//    private ArrayList<Clube> times = new ArrayList<>();
//
//    public void geracaoTabela(Clube id) {
//        times.add(id);
//
//        int numeroTimes = times.size();
//
//        if (numeroTimes % 2 != 0) {
//            times.add("Descanso");
//            numeroTimes++;
//        }
//
//        int numeroRodadas = numeroTimes - 1;
//
//        for (int rodada = 0; rodada < numeroRodadas; rodada++) {
//            System.out.println("Rodada " + (rodada + 1) + ":");
//
//            int jogosExibidos = 0;
//
//            for (int i = 0; i < numeroTimes / 2 && jogosExibidos < numeroTimes / 2 - 1; i++) {
//                int time1 = i;
//                int time2 = numeroTimes - 1 - i;
//                if (!times.get(time1).equals("Descanso") && !times.get(time2).equals("Descanso")) {
//                    System.out.println(times.get(time1) + " vs " + times.get(time2));
//                }
//            }
//
//            String timeRemovido = times.removeLast();
//            times.add(1, timeRemovido);
//        }
//    }
//
//}