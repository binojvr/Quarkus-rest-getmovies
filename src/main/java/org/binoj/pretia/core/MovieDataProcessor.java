package org.binoj.pretia.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.binoj.pretia.model.Movie;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class MovieDataProcessor {

	@ConfigProperty(name="base.url.movie.title")
	private String moviesBaseURL;

	@Inject
	private MovieDBServiceClient moviesClient;

	public List<String> getMovieTitles(String titleSubstr) {

		StringBuffer url = new StringBuffer();
		url.append(moviesBaseURL).append(titleSubstr);
		List<Movie> movies = moviesClient.getMovieTitles(url.toString());
		return sorttedMovieTitles(movies);

	}

	private List<String> sorttedMovieTitles(List<Movie> movies) {

		List<String> titles = new ArrayList<>();
		movies.parallelStream().forEach(m -> titles.add(m.getTitle()));
		Collections.sort(titles);
		return titles;
	}

}
