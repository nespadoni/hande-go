package com.gestaoesportiva.handego.application.federacao.repository;

import com.gestaoesportiva.handego.application.federacao.entity.Federacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FederacaoRepository extends JpaRepository<Federacao, Long> {
}
