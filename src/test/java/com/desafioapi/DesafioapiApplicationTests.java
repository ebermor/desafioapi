package com.desafioapi;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.opencsv.exceptions.CsvException;

import db.CsvToH2;

@SpringBootTest
class DesafioapiApplicationTests {

	@Test
	void contextLoads() throws IOException, CsvException {
		//CsvToH2 loadCsv = new CsvToH2();
		//loadCsv.loadMoviesCsv();
	}

}
