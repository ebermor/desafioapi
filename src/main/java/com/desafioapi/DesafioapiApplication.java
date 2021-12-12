package com.desafioapi;


import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opencsv.exceptions.CsvException;

import db.CsvToH2;

@SpringBootApplication
public class DesafioapiApplication {

	public static void main(String[] args) throws IOException, CsvException {
		SpringApplication.run(DesafioapiApplication.class, args);
//		CsvToH2 loadCsv = new CsvToH2();
//		loadCsv.loadteste();
	}

}
