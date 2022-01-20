package com.rafael.helpdesk.domain.enums;

public enum Prioridade {
	
	//Lista de Enums
	BAIXA (0, "BAIXA"),
	MEDIA (1, "MEDIA"),
	ALTA (2, "ALTA");
	
	//Atributos
	private Integer codigo;
	private String descricao;
	
	//Construtor do Enum
	private Prioridade(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	//Retorna um Enum de acordo com o código informado
	public static Prioridade toEnum (Integer codigo) {
		if (codigo == null) {
			return null;
		}
		for (Prioridade p : Prioridade.values()) {
			if (codigo.equals(p.getCodigo())) {
				return p;
			}
		}
		throw new IllegalArgumentException("Prioridade inválida");
	}

	//Getters dos atributos
	public Integer getCodigo() {
		return codigo;
	}


	public String getDescricao() {
		return descricao;
	}
}