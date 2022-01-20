package com.rafael.helpdesk.domain.enums;

public enum Perfil {
	
	//Lista de Enums
	ADMIN (0, "ROLE_ADMIN"),
	CLIENTE (1, "ROLE_CLIENTE"),
	TECNICO (2, "ROLE_TECNICO");
	
	//Atributos
	private Integer codigo;
	private String descricao;
	
	//Construtor do Enum
	private Perfil(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	//Retorna um Enum de acordo com o código informado
	public static Perfil toEnum (Integer codigo) {
		if (codigo == null) {
			return null;
		}
		for (Perfil p : Perfil.values()) {
			if (codigo.equals(p.getCodigo())) {
				return p;
			}
		}
		throw new IllegalArgumentException("Perfil inválido");
	}

	//Getters dos atributos
	public Integer getCodigo() {
		return codigo;
	}


	public String getDescricao() {
		return descricao;
	}
}