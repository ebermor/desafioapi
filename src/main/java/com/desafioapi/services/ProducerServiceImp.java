package com.desafioapi.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioapi.repositories.ProducerRepository;

import winners.IntervalWinners;
import winners.Winners;

@Service
public class ProducerServiceImp implements ProducerService {
	private static final Logger log = LoggerFactory.getLogger(ProducerServiceImp.class);
	@Autowired
	ProducerRepository producerRepository;

	public IntervalWinners getPeriodInterval() {

		List<ProducerService> producerservice = producerRepository.getAllWinner();
		
		List<Winners> winnersList = new ArrayList<>();
		

		producerservice.forEach(producerInterface -> {
			Winners winners = new Winners();
			winners.setProducer(producerInterface.getName());
			winners.setInterval(producerInterface.getNextYear() - producerInterface.getYear());
			winners.setPreviousWin(producerInterface.getYear());
			winners.setFollowingWin(producerInterface.getNextYear());
			winnersList.add(winners);
		});
		
		Integer intervalMin = winnersList.stream().min(Comparator.comparing(Winners::getInterval)).get().getInterval();

		Integer intervalMax = winnersList.stream().max(Comparator.comparing(Winners::getInterval)).get().getInterval();

		IntervalWinners intervalWinners = new IntervalWinners();
		winnersList.stream().filter(p -> p.getInterval() == intervalMax).forEach(max -> {
			intervalWinners.setMax(max);
		});

		winnersList.stream().filter(p -> p.getInterval() == intervalMin).forEach(max -> {
			intervalWinners.setMin(max);
		});

		return intervalWinners;

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getYear() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNextYear() {
		// TODO Auto-generated method stub
		return 0;
	}

}
