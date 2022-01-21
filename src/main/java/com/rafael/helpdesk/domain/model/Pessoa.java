package com.rafael.helpdesk.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rafael.helpdesk.domain.enums.Perfil;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Entity
public abstract class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Integer id;
	
	@Column (nullable = false)
	protected String nome;
	
	@CPF
	@Column (nullable = false, unique = true, length = 11)
	protected String cpf;
	
	@Column (nullable = false, unique = true)
	protected String email;
	
	@Column (nullable = false)
	protected String senha;
	
	@Column (nullable = false, columnDefinition = "date", updatable = false)
	@JsonFormat (pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();
	
	@ElementCollection (fetch = FetchType.EAGER)
	@CollectionTable (name = "PERFIS")
	protected Set<Perfil> perfis = new HashSet<>();

	//Construtor da classe
	public Pessoa(Integer id, String nome, String cpf, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
	}
}