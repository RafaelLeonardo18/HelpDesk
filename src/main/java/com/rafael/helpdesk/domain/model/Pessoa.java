package com.rafael.helpdesk.domain.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.rafael.helpdesk.domain.enums.Perfil;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class Pessoa {
	
	protected Integer id;
	protected String nome;
	protected String cpf;
	protected String email;
	protected String senha;
	protected LocalDate dataCriacao = LocalDate.now();
	protected Set<Perfil> perfis = new HashSet<>();
	

	public Pessoa(Integer id, String nome, String cpf, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
	}
}