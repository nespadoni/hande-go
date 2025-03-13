package com.gestaoesportiva.handego.application.campeonato.repository;

import com.gestaoesportiva.handego.application.campeonato.entity.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampeonatoRepository extends JpaRepository<Campeonato, Long> {
}
