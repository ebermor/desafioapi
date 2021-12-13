package com.desafioapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafioapi.entity.Movie;


public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	Optional<Movie> findById(Long id);
	
}
