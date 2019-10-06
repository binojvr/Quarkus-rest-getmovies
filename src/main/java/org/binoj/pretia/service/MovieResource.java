package org.binoj.pretia.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.binoj.pretia.core.MovieDataProcessor;

@Path("/movie")
public class MovieResource {

	@Inject
	MovieDataProcessor movieDataProcessor;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getMovieTitles(@QueryParam("title") String title) {
		return movieDataProcessor.getMovieTitles(title);
	}
}