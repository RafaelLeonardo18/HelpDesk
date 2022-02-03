package com.rafael.helpdesk.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import com.rafael.helpdesk.domain.enums.Perfil;
import com.rafael.helpdesk.domain.enums.Prioridade;
import com.rafael.helpdesk.domain.enums.Status;
import com.rafael.helpdesk.domain.model.Chamado;
import com.rafael.helpdesk.domain.model.Cliente;
import com.rafael.helpdesk.domain.model.Tecnico;
import com.rafael.helpdesk.utils.DocumentUtils;

@Service
public class DBService {
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ChamadoService chamadoService;
	
	@Autowired
	private ClienteService clienteService;
		
	//Inicializa as instâncias no banco de dados
	public void initializeDataBase() throws Exception {	
		Faker faker = new Faker(new Locale("pt-BR"));
		
		var tecnico = new Tecnico(faker.name().fullName(), DocumentUtils.generateCpf(), faker.internet().emailAddress(), "123");
		tecnico.getPerfis().add(Perfil.ADMIN);
		tecnicoService.save(tecnico);
		
		var cliente = new Cliente(faker.name().fullName(), DocumentUtils.generateCpf(), faker.internet().emailAddress(), "123");
		cliente.getPerfis().add(Perfil.CLIENTE);
		clienteService.save(cliente);
		
		var chamado = new Chamado("Roteador quebrado", "Segundo chamado", Prioridade.MEDIA, Status.ANDAMENTO, tecnico, cliente);
		chamadoService.save(chamado);
		
	}

}