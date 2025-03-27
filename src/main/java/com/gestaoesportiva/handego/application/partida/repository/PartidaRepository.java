package com.gestaoesportiva.handego.application.partida.repository;

import com.gestaoesportiva.handego.application.partida.entity.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {
}
