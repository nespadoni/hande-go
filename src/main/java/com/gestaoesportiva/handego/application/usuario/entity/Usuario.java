package com.gestaoesportiva.handego.application.usuario.entity;

import com.gestaoesportiva.handego.application.usuario.dto.UsuarioRequest;
import com.gestaoesportiva.handego.application.usuario.dto.UsuarioUpdate;
import com.gestaoesportiva.handego.domain.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String cpf;
    private String cidade;
    private String estado;
    private Boolean ativo;

    public Usuario(UsuarioRequest dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
        this.telefone = dados.telefone();
        this.role = dados.role();
        this.cpf = dados.cpf();
        this.cidade = dados.cidade();
        this.estado = dados.estado();
        this.ativo = true;
    }


    public void atualizar(UsuarioUpdate dados) {
        if (dados.nome() != null) this.nome = dados.nome();
        if (dados.email() != null) this.email = dados.email();
        if (dados.senha() != null) this.senha = dados.senha();
        if (dados.telefone() != null) this.telefone = dados.telefone();
        if (dados.role() != null) this.role = dados.role();
        if (dados.cpf() != null) this.cpf = dados.cpf();
        if (dados.cidade() != null) this.cidade = dados.cidade();
        if (dados.estado() != null) this.estado = dados.estado();

    }

}
