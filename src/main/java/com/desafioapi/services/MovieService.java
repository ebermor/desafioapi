package com.desafioapi.services;

import java.util.Optional;

import com.desafioapi.entity.Movie;

public interface MovieService {
	
	/**
	 * Return a movie for id
	 * @param Id
	 * @return
	 */
	Optional<Movie> buscarPorId(Long Id);
	
	/**
	 * Insert new movie in database
	 * @param movie
	 * @return
	 */
	Movie insert(Movie movie);

}
