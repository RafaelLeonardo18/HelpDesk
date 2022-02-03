package com.rafael.helpdesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafael.helpdesk.domain.model.Cliente;
import com.rafael.helpdesk.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private final ClienteRepository clienteRepository;
	
	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	@Transactional(readOnly = true)
	public Cliente findById(Long id) throws Exception {
		return clienteRepository.findById(id).orElseThrow(() -> new Exception("Cliente não encontrado!"));
	}
	
	@Transactional(readOnly = true)
	public List<Cliente> findAll() throws Exception {
		return clienteRepository.findAll();
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Cliente save(Cliente cliente) throws Exception {
		return clienteRepository.save(cliente);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Cliente cliente) throws Exception {
		clienteRepository.delete(cliente);
	}

}