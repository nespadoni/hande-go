package com.gestaoesportiva.handego.application.usuario.repository;

import com.gestaoesportiva.handego.application.usuario.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Page<Usuario> findByAtivoTrue(Pageable pageable);
}
