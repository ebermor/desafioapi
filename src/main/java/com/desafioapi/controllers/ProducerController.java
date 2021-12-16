package com.desafioapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioapi.response.Response;
import com.desafioapi.services.ProducerService;

import winners.IntervalWinners;

@RestController
@RequestMapping("/api/producer")
@CrossOrigin(origins = "*")
public class ProducerController {
	@Autowired
	private ProducerService producerService;

	@GetMapping("/interval")
	public ResponseEntity<Response<IntervalWinners>> getInterval() {
		Response<IntervalWinners> response = new Response<IntervalWinners>();
		IntervalWinners interv = producerService.getPeriodInterval();
		
		response.setData(interv);

		return ResponseEntity.ok(response);

	}

}
