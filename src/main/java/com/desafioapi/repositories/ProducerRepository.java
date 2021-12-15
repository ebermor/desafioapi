package com.desafioapi.repositories;

import java.util.List;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.desafioapi.entity.Producer;
import com.desafioapi.services.ProducerService;



public interface ProducerRepository extends JpaRepository<Producer, Long> {
	
	@Transactional(readOnly = true)
	@Query(nativeQuery = true, value = "with cte as (select m.year\r\n"
							+ "                  ,	p.name\r\n"
							+ "				  , (SELECT m2.year\r\n"
							+ "                       FROM	movie m2      \r\n"
							+ "					  INNER JOIN producer p2      \r\n"
							+ "						 ON m2.id = p2.movie_id     \r\n"
							+ "				      WHERE p2.name = p.name      \r\n"
							+ "					    AND m2.winner = true      \r\n"
							+ "					    AND m2.YEAR > m.YEAR     \r\n"
							+ "				      ORDER BY m2.year     LIMIT 1\r\n"
							+ "					 ) AS nextYear  \r\n"
							+ "			   from	movie m    \r\n"
							+ "			  inner join producer p    \r\n"
							+ "				 on m.id = p.movie_id  \r\n"
							+ "			  where m.winner = true  \r\n"
							+ "			  order by p.name\r\n"
							+ "			      , m.year\r\n"
							+ "		    )\r\n"
							+ "	  select year\r\n"
							+ "	       , name\r\n"
							+ "		   , nextYear  \r\n"
							+ "		from cte\r\n"
							+ "   	   where nextYear is not null ")

	
	List<ProducerService> getAllWinner();
	

}
