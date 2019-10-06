package org.binoj.pretia.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.binoj.pretia.model.Movie;
import org.binoj.pretia.model.MovieAPIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

@ApplicationScoped
public class MovieDBServiceClient {

	private static final Logger logger = LoggerFactory.getLogger(MovieDBServiceClient.class);

	/*
	 * Clients are heavy-weight objects and  must be managed efficiently
	 */
	private Client client;
	private ObjectMapper mapper;

	@PostConstruct
	protected void init() {
		client = ClientBuilder.newClient();
		mapper = new ObjectMapper();
	}

	@PreDestroy
	protected void destroy() {
		if (client != null) {
			client.close();
			client = null;
		}
		mapper = null;
	}

	public List<Movie> getMovieTitles(String url) {
		List<Movie> emptyMovies = new ArrayList<>();

		return getMovieTitles(emptyMovies, url, 1);
	}

	public List<Movie> getMovieTitles(List<Movie> movies, String url, int pageNumber) {

		StringBuffer urlWithqString = new StringBuffer(url);
		urlWithqString.append("&page=").append(pageNumber);

		String response = client.target(urlWithqString.toString()).request().get(String.class);

		MovieAPIResponse resp = null;// optional

		try {
			resp = mapper.readValue(response, MovieAPIResponse.class);
		} catch (IOException e) {

			logger.warn("response " + e.getLocalizedMessage());
			return movies;

		}
		
		movies.addAll(resp.getData());
		int curPage = resp.getPage();
		int totalPages = resp.getTotalPages();

		if (totalPages > curPage)
			getMovieTitles(movies,url, curPage + 1);

		return movies;
	}

}
