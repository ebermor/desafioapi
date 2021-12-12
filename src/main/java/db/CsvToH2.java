package db;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.desafioapi.entity.Movie;
import com.desafioapi.services.MovieService;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

public class CsvToH2 {
	private static final Logger log = LoggerFactory.getLogger(CsvToH2.class);
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	Movie movie;
	
	public String adjustmentTrimming(String strTrimming) {
//		log.info(strTrimming);
		strTrimming = strTrimming.replaceAll("^\\s+", "");
		strTrimming = strTrimming.replaceAll("\\s+$", "");
		return strTrimming;
	};
	
	public String adjust(String[] csvLista, int pos) {
		if (csvLista.length > pos && csvLista[pos] != null && pos < 4) {
			return adjustmentTrimming(csvLista[pos]);
		} else {
			return "N/D";
		}
	};
	
	public void loadteste() throws IOException, CsvException {
		
		String line = "";
		char splitBy = ';';
		
	
		
		log.info("teste leitura csv");
		ClassLoader classLoader = getClass().getClassLoader();
		String path  = classLoader.getResource("movielist.csv").getPath();	
    	path = path.replaceAll("/C:", "C:");
		String csvFile = Paths.get(path).toString();
		
		System.out.println(".........................................................");
		System.out.println("... LOAD DATA BEGIN ..................................");
		System.out.println(".........................................................");
		System.out.println("Path to CSV File " + csvFile);
		
		//reader file csv movies
		FileReader filereader = new FileReader(csvFile);
		
		//perse with separator
		CSVParser parser = new CSVParserBuilder().withSeparator(splitBy).build();
		
		//reader with parse start second line
		CSVReader csvReader = new CSVReaderBuilder(filereader)
				.withSkipLines(1)
                .withCSVParser(parser)
                .build();
		
		// Read all data at once
        List<String[]> allData = csvReader.readAll();
        for (String[] row : allData) {
        	String year = row[0];
        	String title = row[1];
        	String winner = row[4];
        	
        	//adjust winner 
        	winner = winner.equalsIgnoreCase("yes")? winner : "no";
            log.info("ano: " + year + " titulo: " + title + " winner: " + winner);	
            
            Movie movie = new Movie();
            
            movie.setTitle(title);
            movie.setWinner(Boolean.valueOf(winner));
            movie.setYear(Integer.valueOf(year));
           
          
            
        	// iterate studios
        	String[] studios = row[2].split(",");
            for (String cell : studios) {
                log.info("studio: " + cell);
            }
           // iterate producer
           String[] producers = row[3].split(",");
            
        	for (String cell : producers) {
                log.info("producer: " + cell);
            }
            
        }
        
    
        
		
		
        };
                          
                            
            		       
		
	
}
