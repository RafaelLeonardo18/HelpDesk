package com.rafael.helpdesk.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.rafael.helpdesk.domain.enums.Perfil;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tecnico extends Pessoa {
	
	private List<Chamado> chamados = new ArrayList<Chamado>();

	//Construtor da classe
	public Tecnico() {
		super();
		this.perfis.add(Perfil.TECNICO);
	}

	public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		this.perfis.add(Perfil.TECNICO);
	}
}