package com.rafael.helpdesk.domain.model;

import java.time.LocalDate;

import com.rafael.helpdesk.domain.enums.Prioridade;
import com.rafael.helpdesk.domain.enums.Status;

import lombok.Data;

@Data
public class Chamado {
	
	private Integer id;
	private String titulo;
	private String observacoes;
	private Prioridade prioridade;
	private Status status;
	private LocalDate dataAbertura = LocalDate.now();
	private LocalDate dataFechamento;
	private Tecnico tecnico;
	private Cliente cliente;
}