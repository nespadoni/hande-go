package com.gestaoesportiva.handego.application.clube.repository;

import com.gestaoesportiva.handego.application.clube.entity.Clube;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubeRepository extends JpaRepository<Clube, Long> {
}
