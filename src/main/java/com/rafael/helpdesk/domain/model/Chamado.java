package com.rafael.helpdesk.domain.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rafael.helpdesk.domain.enums.Prioridade;
import com.rafael.helpdesk.domain.enums.Status;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString @NoArgsConstructor
@Entity
public class Chamado implements Serializable {
	
	public static final long serialVersionUID = 1L;
	
	//Construtor da classe
	public Chamado(String titulo, String observacoes, Prioridade prioridade, Status status, Tecnico tecnico, Cliente cliente) {
		this.titulo = titulo;
		this.observacoes = observacoes;
		this.prioridade = prioridade;
		this.status = status;
		this.tecnico = tecnico;
		this.cliente = cliente;	
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@Column (nullable = false)
	private String titulo;
	
	@Column (nullable = false)
	private String observacoes;
	
	@Column (nullable = false)
	private Prioridade prioridade;
	
	@Column (nullable = false)
	private Status status;
	
	@Column (nullable = false, columnDefinition = "date", updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAbertura = LocalDate.now();
	
	@Column (nullable = true, columnDefinition = "date", updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFechamento;
	
	@ManyToOne (optional = false, cascade = CascadeType.REMOVE)
	private Tecnico tecnico;
	
	@ManyToOne (optional = false, cascade = CascadeType.REMOVE)
	private Cliente cliente;
}