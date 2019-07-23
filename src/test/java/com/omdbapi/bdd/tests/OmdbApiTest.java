package com.omdbapi.bdd.tests;

import com.omdbapi.bdd.steps.SearchMovieSteps;
import com.omdbapi.bdd.utils.OmdbApi;

import org.apache.http.HttpStatus;
import org.junit.Test;


public class OmdbApiTest  {

	@Test
	public void GetSchemaSucces() {

		final SearchMovieSteps steps = new SearchMovieSteps(new OmdbApi());

		steps.theMovieWithTitleIs("Iron Man")
			.iGetTheMovie()
			.statusCodeIs(HttpStatus.SC_OK)
			.actorIsAString()
			.yearIsAInteger()
			.ratingsIsAArray();
	}
	
	@Test
	public void RatingsSizeSuccess() {
		
		final SearchMovieSteps steps = new SearchMovieSteps(new OmdbApi());

		steps.theMovieWithTitleIs("Avengers")
			.theMovieYearIs(2019)
			.iGetTheMovie()
			.statusCodeIs(HttpStatus.SC_OK)
			.ratingsIsArrayWithSize(2);
	}

	@Test
	public void MovieNotFoundSuccess() {
		
		final SearchMovieSteps steps = new SearchMovieSteps(new OmdbApi());

		steps.theMovieWithTitleIs("Avengers")
			.theMovieYearIs(2021)
			.iGetTheMovie()
			.statusCodeIs(HttpStatus.SC_OK)
			.movieNotFound();
	}	
    
}