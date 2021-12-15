package com.desafioapi.services;

import winners.IntervalWinners;

public interface ProducerService {
	String getName();

	int getYear();

	int getNextYear();

	IntervalWinners getPeriodInterval();
}
