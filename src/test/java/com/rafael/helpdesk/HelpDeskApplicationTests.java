package com.rafael.helpdesk;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.rafael.helpdesk.service.DBService;

@SpringBootTest (classes = HelpDeskApplicationTests.class)
class HelpDeskApplicationTests {

	@Test
	void contextLoads() throws Exception {
		DBService dbs = new DBService();
		dbs.initializeDataBase();
	}

}