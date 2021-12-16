package com.desafioapi;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.desafioapi.services.ProducerService;
import com.opencsv.exceptions.CsvException;

@SpringBootTest
@ActiveProfiles("test")

class DesafioapiApplicationTests {

	@Autowired
	ProducerService producerService;

	
	
	void contextLoads() throws IOException, CsvException {
	
	}

	
	

}
