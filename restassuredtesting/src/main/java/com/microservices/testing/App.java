package com.microservices.testing;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

public class App{
	@Test
	public void checkAreaOutput(){
		expect().body("area",equalTo("50")).when().get("http://localhost:8081/customer?length=10&width=10");
	}
	
	@Test
	public void checkLengthPrecision(){
		expect().body("len",equalTo("10.01")).when().get("http://localhost:8081/customer?length=10.0101&width=10");
	}
	
	@Test
	public void checkwidthPrecision(){
		expect().body("width",equalTo("10.02")).when().get("http://localhost:8081/customer?length=10.0101&width=10.0190");
	}
	
	@Test
	public void checkAreaPrecision(){
		expect().body("area",equalTo("50.7")).when().get("http://localhost:8081/customer?length=10.1211&width=10.0190");
	}
	
	@Test
	public void checkLengthfieldValidation(){
		expect().body("area",equalTo("incorrect input values")).when().get("http://localhost:8081/customer?length=999999999&width=10.0190");
	}
}
