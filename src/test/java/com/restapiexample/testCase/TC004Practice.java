package com.restapiexample.testCase;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004Practice {
	
	
	@Test
	public void img() {
		RestAssured.baseURI="";
		RequestSpecification httpReq = RestAssured.given();
		JSONObject jsParam = new JSONObject();
		jsParam.put("", "");
		Response response =	httpReq.request(Method.POST);

		
	}

}
