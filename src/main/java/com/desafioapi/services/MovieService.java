package com.desafioapi.services;

import java.util.List;
import java.util.Optional;

import com.desafioapi.entities.Movie;

public interface MovieService {
	
	/**
	 * Return a movie for id
	 * @param Id
	 * @return
	 */
	Optional<Movie> buscarPorId(Long Id);
	
	List<Movie> findAll();


}
