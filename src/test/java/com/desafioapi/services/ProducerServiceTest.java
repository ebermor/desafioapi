package com.desafioapi.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import winners.IntervalWinners;


//@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ProducerServiceTest {
	private static final Logger log = LoggerFactory.getLogger(ProducerServiceTest.class);

	
	@Autowired
	ProducerService producerService;
	
	
	
	@Test
	void validateReturnMaxByPeriodInterval() {
		log.info("TESTE TESTE");
		IntervalWinners intervalsWinners = producerService.getPeriodInterval();
		assertThat(intervalsWinners).isNotNull();
	}

}
