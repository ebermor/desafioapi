package com.desafioapi.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.opencsv.exceptions.CsvException;

import db.CsvToH2;
import winners.IntervalWinners;
import winners.Winners;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ProducerServiceTest {
	private static final Logger log = LoggerFactory.getLogger(ProducerServiceTest.class);

	@Autowired
	ProducerService producerService;

	@Before
	public void setUp() throws Exception {
		log.info("INICIAL TESTE");
		CsvToH2 loadCsv = new CsvToH2();
		loadCsv.loadMoviesCsv();

	}

	@Test
	void validateReturnMax() throws IOException, CsvException {
		log.info("TESTE TESTE");
		CsvToH2 loadCsv = new CsvToH2();
		loadCsv.loadMoviesCsv();
		IntervalWinners intervalsWinners = producerService.getPeriodInterval();
		assertThat(intervalsWinners).isNotNull();
		Winners intervalMax = intervalsWinners.getMax().iterator().next();
		assertThat(intervalMax).isNotNull();
		assertThat(intervalMax.getProducer()).isNotNull();
		assertThat(intervalMax.getInterval() >= 1).isTrue();
	}
	
	@Test
	void validateReturnMaxMin() {
		IntervalWinners intervalsWinners = producerService.getPeriodInterval();
		assertThat(intervalsWinners).isNotNull();
		assertThat(intervalsWinners.getMax()).isNotEmpty();

		Winners intervalMin = intervalsWinners.getMin().iterator().next();
		assertThat(intervalMin).isNotNull();
		assertThat(intervalMin.getProducer()).isNotNull();
		assertThat(intervalMin.getInterval() >= 1).isTrue();
	}

}
