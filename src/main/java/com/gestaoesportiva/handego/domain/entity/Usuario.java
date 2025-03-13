package com.gestaoesportiva.handego.domain.entity;

import com.gestaoesportiva.handego.application.dto.UsuarioRequest;
import com.gestaoesportiva.handego.application.dto.UsuarioResponse;
import com.gestaoesportiva.handego.application.dto.UsuarioUpdate;
import com.gestaoesportiva.handego.domain.enumeration.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.domain.Page;

import java.util.UUID;

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
    private boolean ativo;

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
        if (dados.id() != null) this.id = dados.id();
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
