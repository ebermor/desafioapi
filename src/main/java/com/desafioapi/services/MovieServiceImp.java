package com.desafioapi.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.desafioapi.entity.Movie;
import com.desafioapi.repositories.MovieRepository;


@Service
public class MovieServiceImp implements MovieService {
	private static final Logger log = LoggerFactory.getLogger(MovieServiceImp.class);

	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public Movie insert(Movie movie) {
		
		return movieRepository.save(movie);
	}

	@Override
	public Optional<Movie> buscarPorId(Long Id) {
		log.info("searching movie for id");
		
		return movieRepository.findById(Id);
		
	}

}
