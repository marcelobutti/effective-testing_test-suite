package com.effectivetesting.sanity;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class TestEntry {
	private static final String DEFAULT_BASE_URL = "http://localhost:5000/api";
	
	@Test
	public void getStoredEntry() {
        given()
    		.contentType("application/json")
    	
	    .when()
			.get(DEFAULT_BASE_URL + "/entry/3")
	    	
		.then()
			.body("title", equalTo("entry mb 2"));
	}
}
