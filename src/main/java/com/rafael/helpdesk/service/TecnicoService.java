package com.rafael.helpdesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafael.helpdesk.domain.model.Tecnico;
import com.rafael.helpdesk.repository.TecnicoRepository;

@Service
public class TecnicoService {
	
	private final TecnicoRepository tecnicoRepository;
	
	@Autowired
	public TecnicoService(TecnicoRepository tecnicoRepository) {
		this.tecnicoRepository = tecnicoRepository;
	}
	
	@Transactional(readOnly = true)
	public Tecnico findById(Long id) throws Exception {
		return tecnicoRepository.findById(id).orElseThrow(() -> new Exception("Tecnico não encontrado!"));
	}
	
	@Transactional(readOnly = true)
	public List<Tecnico> findAll() throws Exception {
		return tecnicoRepository.findAll();
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Tecnico save(Tecnico tecnico) throws Exception {
		return tecnicoRepository.save(tecnico);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Tecnico tecnico) throws Exception {
		tecnicoRepository.delete(tecnico);
	}

}