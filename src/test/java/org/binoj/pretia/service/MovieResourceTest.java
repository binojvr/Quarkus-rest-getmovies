package org.binoj.pretia.service;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import javax.annotation.PostConstruct;
import javax.ws.rs.client.ClientBuilder;

@QuarkusTest
public class MovieResourceTest {
	
	private ObjectMapper mapper;

	@PostConstruct
	protected void init() {
		mapper = new ObjectMapper();
	}

    @Test
    public void testMovieTitleEndpoint() {
        given()
          .when().get("/movie?title=Driving")
          .then()
             .statusCode(200)
             .body(is("[\"Fighting, Flying and Driving: The Stunts of Spiderman 3\"]"));
    }

}