package com.restapiexample.testCase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restapiexample.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_GetSingleEmployeeRecord extends TestBase {

	@BeforeClass
	public void getEmployeeData() {
		logger.info("************Started TC002_GetSingleEmployeeRecord*************");

		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest=RestAssured.given();
		response = httpRequest.request(Method.GET,"'/employee/"+empId);
	}
	
	@Test
	public void checkResponseBody() {
		logger.info("************Checking Response Body*************");
		String responseBody = response.getBody().asString();
		logger.info("responseBody==>"+responseBody);
		Assert.assertEquals(responseBody.contains("empID"), true);
	}
	
	@Test
	public void checkStatusCode() {
		logger.info("************Checking Stutus Code*************");
		int statusCode = response.getStatusCode();
		logger.info("statusCode==>"+statusCode);
		Assert.assertTrue(statusCode==200);
	}
	
	@Test
	public void checkResponseTime() {
		logger.info("************Checking Response Time*************");
		long responseTime =response.getTime();
		logger.info("Response Time==>"+responseTime);
		if(responseTime>2000) {
			logger.warn("Response time is greater than 2000");
		}
		Assert.assertTrue(responseTime<5000);
	}
	
	@Test
	public void checkStatusLine() {
		logger.info("************Checking Status Line*************");
		String statusLine = response.statusLine();
		logger.info("status Line==>"+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test
	public void checkContentType() {
		logger.info("************Checking Content Type*************");
		String contentType = response.contentType();
		logger.info("content Type==>"+contentType);
		Assert.assertEquals(contentType, "application/json");
	}
	
	@Test
	void checkServerType() {
		logger.info("************Checking Content Type*************");
		String serverType = response.header("Server-Type");
		logger.info("server Type==>"+serverType);
		Assert.assertEquals(serverType, "nginx/1.21.6");
	}
	
	@Test
	public void checkContentEncoding() {
		logger.info("************Checking Content Encoding*************");
		String contentEncoding =response.header("Content-Encoding");
		logger.info("content Encoding==>"+contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
	}
	
	@Test
	public void checkContentLength() {
		logger.info("************Checking Content Length*************");
		String contentLength = response.header("Content-Length");
		logger.info("content Length==>"+contentLength);
		Assert.assertTrue(Integer.parseInt(contentLength)<1500);
	}
	
	
	@AfterClass
		void tearDown() {
		logger.info("************Finished TC002_GetSingleEmployeeRecord*************");
	}
	
}
