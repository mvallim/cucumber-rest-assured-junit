package com.omdbapi.bdd.utils;

import static io.restassured.RestAssured.given;

import io.restassured.specification.RequestSpecification;

public class OmdbApi {

    private RequestSpecification spec;

    public OmdbApi() {
        this.spec = given()
            .relaxedHTTPSValidation()
            .port(Constants.PORT)
            .baseUri(Constants.HOST)
            .queryParam("apikey", Constants.API_KEY)
            .when();
    }

    public RequestSpecification getSpec() {
        return this.spec;
    }
    
}