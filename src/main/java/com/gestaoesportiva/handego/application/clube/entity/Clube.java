package com.gestaoesportiva.handego.application.clube.entity;

import com.gestaoesportiva.handego.application.campeonato.entity.Campeonato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class Clube {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sigla;
    private String email;
    private String senha;
    private String telefone;
    private String cnpj;
    private String estado;

    @ManyToMany(mappedBy = "clubes")
    private Set<Campeonato> campeonatos = new HashSet<>();

    private Boolean ativo;
}
