package com.omdbapi.bdd.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
    snippets = SnippetType.CAMELCASE,
    strict = true,
    plugin = {"pretty", "junit:target/junit-search-movie-test.xml", "json:target/search-movie-test.json"},
    features = "classpath:feature",
    glue = "com.omdbapi.bdd.steps")
public class SearchMovieTest {

}