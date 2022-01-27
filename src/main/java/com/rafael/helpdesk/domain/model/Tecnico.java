package com.rafael.helpdesk.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.rafael.helpdesk.domain.enums.Perfil;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Tecnico extends Pessoa {
	
	private static final long serialVersionUID = 1L;
	
	@OneToMany (mappedBy = "tecnico", fetch = FetchType.LAZY)
	private List<Chamado> chamados = new ArrayList<Chamado>();

	//Construtor da classe
	public Tecnico() {
		super();
		this.perfis.add(Perfil.TECNICO);
	}

	public Tecnico(Long id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		this.perfis.add(Perfil.TECNICO);
	}
}