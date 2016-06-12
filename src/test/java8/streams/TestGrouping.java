package test.java8.streams;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;
import test.java8.utils.Utility;

public class TestGrouping {
	public static void main(String[] args) {
		
		List<Movie> movies = createListOfMoviesFewSameNames();
		
		useGroupingBy(movies);
		
		useGroupingByMapping(movies);
		
			
	}

	/**
	 * @return
	 */
	private static List<Movie> createListOfMoviesFewSameNames() {
		List<Movie> movies = Utility.createListOfMovies();
		
		movies.add(new Movie("Godfather 2", 5.0f, 2015));
		movies.add(new Movie("Godfather 1", 1.0f, 2010));
		
		return movies;
	}

	/**
	 * @param movies
	 */
	private static void useGroupingByMapping(List<Movie> movies) {
		Map<String, List<Object>> movieMap=
		movies
		.stream()
		.collect(groupingBy(Movie::getName,mapping(m->m.getYear()+" - "+m.getRating(),toList())));
		
		printMapInteger(movieMap);
	}

	/**
	 * @param movies
	 */
	private static void useGroupingBy(List<Movie> movies) {
		Map<String, List<Movie>> movieMap=
		movies
		.stream()
		.collect(groupingBy(Movie::getName));
		
		printMapMovie(movieMap);
	}

	/**
	 * @param movieMap
	 */
	public static void printMapMovie(Map<String, List<Movie>> movieMap) {
		movieMap.forEach( (k,v)->System.out.println(k+"-"+v) );
	}

	/**
	 * @param movieMap
	 */
	public static void printMapInteger(Map<String, List<Object>> movieMap) {
		movieMap.forEach( (k,v)->System.out.println(k+"-"+v) );
	}
}
