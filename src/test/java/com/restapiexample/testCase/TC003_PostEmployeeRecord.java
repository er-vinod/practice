package com.restapiexample.testCase;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restapiexample.base.TestBase;
import com.restapiexample.utility.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC003_PostEmployeeRecord extends TestBase{
	
	String empName = RestUtils.empName();
	String empSal = RestUtils.empSal();
	String empAge = RestUtils.empAge();
	
	@BeforeClass
	public void createEmployee() {
		logger.info("************Started TC003_PostEmployeeRecord*************");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", empId);
		requestParams.put("salary", empSal);
		requestParams.put("age", empAge);
		httpRequest.body(requestParams.toJSONString());
		response= httpRequest.request(Method.POST,"/create");
	}
	
	@Test
	public void checkResponseBody() {
		logger.info("************Checking Response Body*************");
		String responseBody = response.getBody().asString();
		logger.info("response Body==>"+responseBody);
		Assert.assertEquals(responseBody.contains("success"), true);
	}
	
	@Test
	public void checkStatusCode() {
		logger.info("************Checking Status Code*************");
		int statusCode = response.statusCode();
		logger.info("Status Code==>"+statusCode);
		Assert.assertTrue(statusCode==200);
	}
	
	@Test
	public void checkStatusLine() {
		logger.info("************Checking Status Line*************");
		String statusLine = response.statusLine();
		logger.info("status Line==>"+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test
	public void checkResponsTime() {
		logger.info("************Checking Response Time*************");
		long responseTime = response.getTime();
		logger.info("Response Time==>"+responseTime);
		if(responseTime>2000)
			logger.info("Response Time is greater than 2000");
		Assert.assertTrue(responseTime<5000);
	}
	
	
	
	
	
	
	void tearDown() {
		logger.info("************Finished TC003_PostEmployeeRecord*************");
	}

}
