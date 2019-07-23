package com.omdbapi.bdd.utils;

import io.restassured.http.ContentType;

interface Constants {

    static final String API_KEY = "2299d3d5";
    static final int PORT = 80;
    static final String HOST = "http://www.omdbapi.com";
    static final String REQUEST_CONTENT_TYPE = ContentType.JSON + ";charset=UTF-8";
	static final String RESPONSE_CONTENT_TYPE = ContentType.JSON + ";charset=UTF-8";

}