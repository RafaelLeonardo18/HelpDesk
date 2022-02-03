package com.rafael.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rafael.helpdesk.service.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBService dbService;
	
	@Value ("${spring.jpa.hibernate.ddl-auto}")
	private String ddlValue;
	
	@Bean
	public void init() throws Exception {
		if (ddlValue.equals("update")) {
			this.dbService.initializeDataBase();
		} else {
			System.err.println("Serviço de inicialização do banco de dados não executado !");
		}
	}

}