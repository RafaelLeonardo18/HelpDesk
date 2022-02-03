package com.rafael.helpdesk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.helpdesk.domain.model.Chamado;

@Repository
public interface ChamadoRepository extends JpaRepository <Chamado, Long>{ }