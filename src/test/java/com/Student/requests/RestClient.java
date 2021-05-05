package com.Student.requests;

import com.Student.tests.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestClient extends TestBase{
	
	public Response doGetReq(String reqPath) {
		return RestAssured.given()
					.when()
					.get(reqPath);
	}
	public Response doPostreq(String uri,Object body) {
		return RestAssured.given()
				.contentType(ContentType.JSON)
				.when()
				.body(body)
				.post(uri);
				
			
	}

}
