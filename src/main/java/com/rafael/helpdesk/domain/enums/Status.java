package com.rafael.helpdesk.domain.enums;

public enum Status {
	
	//Lista de Enums
	ABERTO (0, "ABERTO"),
	ANDAMENTO (1, "ANDAMENTO"),
	ENCERRADO (2, "ENCERRADO");
	
	//Atributos
	private Integer codigo;
	private String descricao;
	
	//Construtor do Enum
	private Status(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	//Retorna um Enum de acordo com o código informado
	public static Status toEnum (Integer codigo) {
		if (codigo == null) {
			return null;
		}
		for (Status s : Status.values()) {
			if (codigo.equals(s.getCodigo())) {
				return s;
			}
		}
		throw new IllegalArgumentException("Status inválido");
	}

	//Getters dos atributos
	public Integer getCodigo() {
		return codigo;
	}


	public String getDescricao() {
		return descricao;
	}
}