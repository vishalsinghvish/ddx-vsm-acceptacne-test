package org.vsm;

import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class sampleGetTest {


	public static void main(String[] args) {
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET,"/Chennai"); 
		String Response  = response.getBody().asString();
		System.out.print("The response body is:" +Response);
		
		String ContentType = response.header("Content-Type");
		System.out.println("Header value of Content-Type is: "+ContentType);
		
		String ServerType = response.header("Server");
		System.out.println("Header value of ServerType is: "+ServerType);
		
		String acceptLanguage = response.header("Content-Encoding");
		System.out.println("Header value of Content-Encoding: " + acceptLanguage);
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		String city = jsonPathEvaluator.get("City");
		System.out.println("City received from Response " + city);
		
		Assert.assertEquals(city, "Chennai", "Correct city name received in the Response");
	}
	
}
