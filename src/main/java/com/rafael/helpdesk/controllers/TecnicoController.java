package com.rafael.helpdesk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rafael.helpdesk.domain.model.Tecnico;
import com.rafael.helpdesk.service.TecnicoService;

@RestController
@RequestMapping (value = "/tecnicos")
public class TecnicoController {
	
	private final TecnicoService tecnicoService;
	
	@Autowired
	public TecnicoController(TecnicoService tecnicoService) {
		this.tecnicoService = tecnicoService;
	}
	
	@ResponseBody
	@GetMapping("/{id}")
	public ResponseEntity<?> getTecnico(@PathVariable Long id) throws Exception {
		return new ResponseEntity<Tecnico>(tecnicoService.findById(id), HttpStatus.OK);
	}
	
	
}