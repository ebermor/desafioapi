package com.desafioapi.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioapi.entities.Movie;
import com.desafioapi.repositories.MovieRepository;


@Service
public class MovieServiceImp implements MovieService {
	private static final Logger log = LoggerFactory.getLogger(MovieServiceImp.class);

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Optional<Movie> buscarPorId(Long Id) {
		log.info("searching movie for id");
		
		return movieRepository.findById(Id);
		
	}

	@Override
	public List<Movie> findAll() {
		
		return movieRepository.findAll();
	}

}
