package com.restapiexample.testCase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.restapiexample.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC001_GetAllEmployeeData extends TestBase {

	@BeforeClass
	public void getAllEmployees() {
		logger.info("************Started TC001_GetAllEmployeeData*************");
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest= RestAssured.given();
		response=httpRequest.request(Method.GET,"/employees");
		
	}
	
	@Test
	public void checkResponseBody() {
		
		logger.info("***************checking Response Body*******************");
		String responseBody= response.getBody().asString();
		logger.info("Response Body==>"+responseBody);
		Assert.assertTrue(responseBody!=null);
	}
	
	@Test
	public void checkStatusCode() {
		logger.info("***************checking Response Body*******************");
		int statusCode = response.getStatusCode();
		logger.info("statusCode==>"+statusCode);
		Assert.assertTrue(statusCode== 200);
	}
	
	@Test
	 public void checkResponseTime() {
		 logger.info("***************checking Response Body*******************");
			long responseTime = response.getTime();
			logger.info("Response Time==>"+responseTime);
			
			if(responseTime>2000) {
				logger.warn("Response time is greater than 2000");
			}
			Assert.assertTrue(responseTime<10000);
	}
	
	@Test
	public void checkStatusLine() {
		 logger.info("***************checking Status Line*******************");
		 String statusLine = response.getStatusLine();
		 logger.info("statusLine==>"+statusLine);
		 Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	
	@Test
	public void checkContentType() {
		 logger.info("***************checking Content Type*******************");
		 String contentType = response.contentType();
		 logger.info("contentType==>"+contentType);
		 Assert.assertEquals(contentType, "application/json");
	}
	
	@Test
	public void checkServerType() {
		 logger.info("***************checking Server Type*******************");
		 String serverType = response.header("server");
		 logger.info("serverType==>"+serverType);
		 Assert.assertEquals(serverType, "nginx/1.21.6");
	}
	
	@Test
	public void checkContentEncoding() {
		 logger.info("***************checking Content  Encoding*******************");
		 String contentEncoding = response.header("Content-Encoding");
		 logger.info("contentEncoding==>"+contentEncoding);
		 Assert.assertEquals(contentEncoding, "gzip");
	}
	
	@Test
	public void checkContentLength() {
		 logger.info("***************checking Content  Length*******************");
		 String contentLength = response.header("Content-Length");
		 logger.info("contentLength==>"+contentLength);
		 Assert.assertTrue(Integer.parseInt(contentLength)>100);
	}
	
	@Test
	public void checkingCookies() {
		 logger.info("***************checking Content  Length*******************");
		 String cookies = response.getCookie("PHPPSESSID");
		 logger.info("cookies length==>"+cookies.length());
		 Assert.assertTrue(cookies.length()>0);
	}
	
	@AfterClass
	 void tearDown() {
		 logger.info("***************Finished TC001_GetAllEmployeeData*******************");

	 }
}
