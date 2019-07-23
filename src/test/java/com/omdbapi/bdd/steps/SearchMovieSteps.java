package com.omdbapi.bdd.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

import com.omdbapi.bdd.utils.OmdbApi;

public class SearchMovieSteps {

    private Response response;

    private ValidatableResponse json;

    private OmdbApi omdbApi;

    public SearchMovieSteps(final OmdbApi omdbApi) {
        this.omdbApi = omdbApi;
    }

    @Given("the movie with title is {string}")
    public SearchMovieSteps theMovieWithTitleIs(String title) {
        omdbApi.getSpec().queryParam("t", title);
        return this;
    }

    @When("I get the movie")
    public SearchMovieSteps iGetTheMovie() {
        this.response = buildGet("/");
        this.json = this.response.then();
        return this;
    }

    @Then("status code is {int}")
    public SearchMovieSteps statusCodeIs(Integer statusCode) {
        this.json.statusCode(equalTo(statusCode));
        return this;
    }

    @Then("actor is a string")
    public SearchMovieSteps actorIsAString() {
        this.json.extract().jsonPath().getString("Actors");
        return this;
    }

    @Then("year is a integer")
    public SearchMovieSteps yearIsAInteger() {
        this.json.extract().jsonPath().getInt("Year");
        return this;
    }

    @Then("ratings is a array")
    public SearchMovieSteps ratingsIsAArray() {
        this.json.extract().jsonPath().getList("Ratings");
        return this;
    }

    @Given("the movie year is {int}")
    public SearchMovieSteps theMovieYearIs(Integer year) {
        omdbApi.getSpec().queryParam("y", year);
        return this;
    }

    @Then("ratings is array with size {int}")
    public SearchMovieSteps ratingsIsArrayWithSize(Integer elements) {
        assertThat(this.json.extract().jsonPath().getList("Ratings").size(), greaterThanOrEqualTo(elements));
        return this;
    }

    @Then("movie not found")
    public SearchMovieSteps movieNotFound() {
        this.json.body(
            "Response", equalTo("False"),
            "Error", equalTo("Movie not found!")
        );
        return this;
    }

    Response buildGet(String uri) {
        return omdbApi.getSpec().get(uri);
    }

}