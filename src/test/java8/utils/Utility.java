package test.java8.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import test.java8.streams.Movie;

public interface Utility {

	
	/**
	 * @return
	 */
	public static List<Movie> createListOfMovies() {
		List<Movie> movies = new ArrayList<>();
		
		movies.add(new Movie("Godfather 2", 8.5f, 1982));
		movies.add(new Movie("Godfather 1", 9.0f, 1975));
		movies.add(new Movie("Godfather 3", 8.0f, 1991));
		return movies;
	}

	
}
