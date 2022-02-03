package com.rafael.helpdesk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafael.helpdesk.domain.model.Chamado;
import com.rafael.helpdesk.repository.ChamadoRepository;

@Service
public class ChamadoService {
	
	private final ChamadoRepository chamadoRepository;
	
	@Autowired
	public ChamadoService(ChamadoRepository chamadoRepository) {
		this.chamadoRepository = chamadoRepository;
	}
	
	@Transactional(readOnly = true)
	public Chamado findById(Long id) throws Exception {
		return chamadoRepository.findById(id).orElseThrow(() -> new Exception("Chamado não encontrado!"));
	}
	
	@Transactional(readOnly = true)
	public List<Chamado> findAll() throws Exception {
		return chamadoRepository.findAll();
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Chamado save(Chamado chamado) throws Exception {
		return chamadoRepository.save(chamado);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Chamado chamado) throws Exception {
		chamadoRepository.delete(chamado);
	}

}