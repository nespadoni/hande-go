package com.gestaoesportiva.handego.application.usuario.entity;

import com.gestaoesportiva.handego.application.usuario.dto.UsuarioRequest;
import com.gestaoesportiva.handego.application.usuario.dto.UsuarioUpdate;
import com.gestaoesportiva.handego.domain.enumeration.Role;
import com.gestaoesportiva.handego.domain.model.EntidadeBase;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario extends EntidadeBase {

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
        atualizarBase(dados);
        if (dados.cidade() != null) this.cidade = dados.cidade();
        if (dados.role() != null) this.role = dados.role();
        if (dados.cpf() != null) this.cpf = dados.cpf();

    }

}
