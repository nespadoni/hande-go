package com.gestaoesportiva.handego.domain.repository;

import com.gestaoesportiva.handego.domain.model.Tabela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabelaRepository extends JpaRepository<Tabela, Long> {
}
