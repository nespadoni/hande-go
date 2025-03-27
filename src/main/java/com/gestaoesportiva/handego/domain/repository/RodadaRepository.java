package com.gestaoesportiva.handego.domain.repository;

import com.gestaoesportiva.handego.domain.model.Rodada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RodadaRepository extends JpaRepository<Rodada, Long> {
}
