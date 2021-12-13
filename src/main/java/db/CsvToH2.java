package db;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

public class CsvToH2 {
	private static final Logger log = LoggerFactory.getLogger(CsvToH2.class);

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:mem:movie";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public String adjustTrimming(String strTrimming) {
		strTrimming = strTrimming.replaceAll("^\\s+", "");
		strTrimming = strTrimming.replaceAll("\\s+$", "");
		return strTrimming;
	};

	public String adjust(String[] csvLista, int pos) {
		if (csvLista.length >= pos && csvLista[pos] != null && pos < 4) {
			return adjustTrimming(csvLista[pos]);
		} else {
			return "N/D";
		}
	};

	public void loadMoviesCsv() throws IOException, CsvException {
		try {
			PreparedStatement prepStatement;
			
			// Create H2 DB Connection Object
			Connection conn = null;
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// Open a connection
			log.info("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn.createStatement();
			char splitBy = ';';
			ClassLoader classLoader = getClass().getClassLoader();
			String path = classLoader.getResource("movielist.csv").getPath();
			path = path.replaceAll("/C:", "C:");
			String csvFile = Paths.get(path).toString();

			log.info("LOAD DATA CSV");
			log.info("Path to CSV File " + csvFile);

			// reader file csv movies
			FileReader filereader = new FileReader(csvFile);

			// perse with separator
			CSVParser parser = new CSVParserBuilder().withSeparator(splitBy).build();

			// reader with parse start second line
			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).withCSVParser(parser).build();

			// Read all data at once
			List<String[]> allData = csvReader.readAll();
			int idMovie = 0;
			log.info("Inserting movies...");
			for (String[] row : allData) {
				String year = adjust(row, 0);
				String title = adjust(row, 1);
				String winner = row[4];
				// adjust winner
				winner = winner.equalsIgnoreCase("yes") ? winner : "no";

				// insert movie in database
				conn.setAutoCommit(false);
				prepStatement = conn.prepareStatement("INSERT INTO MOVIE ( year, title, winner) VALUES ( ?, ?, ?)",
						Statement.RETURN_GENERATED_KEYS);
				prepStatement.setString(1, year);
				prepStatement.setString(2, title);
				prepStatement.setString(3, winner);
				idMovie = prepStatement.executeUpdate();
				conn.commit();
				ResultSet rs;
				rs = prepStatement.getGeneratedKeys();
				rs.next();
				idMovie = rs.getInt(1);
				
				// iterate studios
				String[] studios = adjust(row, 2).split(",");
				for (String cell : studios) {
					prepStatement = conn.prepareStatement("INSERT INTO STUDIO ( name, movie_id) VALUES ( ?, ?)");

					prepStatement.setString(1, cell);
					prepStatement.setInt(2, idMovie);
					prepStatement.executeUpdate();
					conn.commit();

				}
				// iterate producer
				String[] producers = adjust(row, 3).split(",");

				for (String cell : producers) {
					prepStatement = conn.prepareStatement("INSERT INTO PRODUCER ( name, movie_id) VALUES ( ?, ?)");

					prepStatement.setString(1, cell);
					prepStatement.setInt(2, idMovie);
					prepStatement.executeUpdate();
					conn.commit();
				}

			}
			log.info("Inserted movies " + idMovie + " records");
			log.info("Process concluded");

		} catch (Exception e) {
			e.printStackTrace();
		}

	};

}
