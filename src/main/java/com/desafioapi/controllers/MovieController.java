package com.desafioapi.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioapi.dtos.MovieDto;
import com.desafioapi.entity.Movie;
import com.desafioapi.services.MovieService;
import com.desafioapi.response.Response;

@RestController
@RequestMapping("/api/movie")
@CrossOrigin(origins = "*")
public class MovieController {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieService movieService; 
	
	public MovieController() {
		log.info("OCNTROLLER START");
		
	}
	
	/**
	 * Return a movie for id
	 * @param Id
	 * @return ResponseEntity<Response<MovieDto>>
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Response<MovieDto>> findById(@PathVariable("id") Long Id){
		
		Response<MovieDto> response = new Response<MovieDto>();
		
		Optional<Movie> movie = movieService.buscarPorId(Id);
		if(!movie.isPresent()) {
			log.info("Movie not found: {}", Id);
			response.getErrors().add("Movie not found " + Id);
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(this.convertMovieDto(movie.get()));
		return ResponseEntity.ok(response);
		
		
	}
	
	@GetMapping("/")
	public ResponseEntity<Response<List<MovieDto>>> findAll(){
		Response<List<MovieDto>> response = new Response<List<MovieDto>>();
		
		List<Movie> movies = movieService.findAll();
		
		List<MovieDto> movieDto = new ArrayList<MovieDto>();
		
	    
		for (Movie name : movies) {
		    movieDto.add(convertMovieDto(name));
		}
		
		response.setData(movieDto);
		return ResponseEntity.ok(response);
		
		
	}

	private MovieDto convertMovieDto(Movie movie) {
		MovieDto movieDto  = new MovieDto();
		movieDto.setId(movie.getId());
		movieDto.setTitle(movie.getTitle());
		movieDto.setWinner(movie.getWinner());
		return movieDto;
	}
	
	

}
