package com.zippopotam.zippomAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;

import org.junit.Test;

public class ZippomAPI {
	 @Test
	    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills() {

	        given().
	        when().
	            get("http://zippopotam.us/us/90210").
	        then().
	            assertThat().
	            body("places[0].'place name'", equalTo("Beverly Hills"));
	    }
	 @Test
	    public void requestUsZipCode90220_checkStatusCode_expect200() {

	        given().
	        when().
	            get("http://zippopotam.us/us/90220").
	        then().
	            assertThat().
	            statusCode(200);
	    }
	 
	 @Test
	    public void requestUsZipCode90220_checkContentType_expectApplicationJson() {

	        given().
	        when().
	            get("http://zippopotam.us/us/90220").
	        then().
	            assertThat().
	            contentType("application/json");
	    }
	 
	 @Test
	    public void requestUsZipCode90220_logRequestAndReponseDetails() {

	        given().
	        log().all().
	        when().
	            get("http://zippopotam.us/us/90220").
	        then().
	            assertThat().
	            log().body();
	    }
	 
	 @Test
	    public void requestUsZipCode90210_CheckStateNameInResponseBody_ExpectCalifornia() {

	        given().
	        when().
	            get("http://zippopotam.us/us/90210").
	        then().
	            assertThat().
	            body("places[0].state", equalTo("California"));
	    }
	 
	 @Test
	    public void requestUsZipCode90210_CheckListOfPlaceNameInResponseBody_ExpectContainsBeverlyHills() {

	        given().
	        when().
	            get("http://zippopotam.us/us/90210").
	        then().
	            assertThat().
	            body("places.'place name'", hasItem("Beverly Hills"));
	    }
	 
	 @Test
	    public void requestUsZipCode90210_CheckNumberOfPlaceNameInResponseBody_ExpectOne() {

	        given().
	        when().
	            get("http://zippopotam.us/us/90210").
	        then().
	            assertThat().
	            body("places.'place name'", hasSize(1));
	    }
}
