package com.desafioapi;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.desafioapi.services.ProducerService;
import com.desafioapi.services.ProducerServiceTest;
import com.opencsv.exceptions.CsvException;

@SpringBootTest
@ActiveProfiles("test")

class DesafioapiApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(ProducerServiceTest.class);

	@Autowired
	ProducerService producerService;

	
	
	void contextLoads() throws IOException, CsvException {
	
	}

	
	

}
