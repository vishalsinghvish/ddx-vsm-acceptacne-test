package org.vsm.stepDefinitions;

import java.util.HashMap;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.vsm.VSMTestRunner;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

public class baseSteps {
	
	static JSONObject ReqBody = new JSONObject(); 
	static Response Response;
	static String StatusCode = "statusCode";
	PropertyReader pr = new PropertyReader();
	HashMap<String, Object> endPointMap = pr.ReadPropertyFile("endpoint.properties");
	HashMap<String, Object> envMap = pr.ReadPropertyFile("environment.properties");

	@Given("^a maximal request \"([^\"]*)\"$")
	public void a_maximal_request(String requestWrapper){
		RestAssured.baseURI = (String) envMap.get(requestWrapper);
	}
	
	@Given("^a (maximal|minimal) request \"([^\"]*)\" from \"([^\"]*)\"$")
	public void a_maximal_request_from(String requestWrapper, String location) {

	}

	@Given("^request field \"([^\"]*)\" is \"([^\"]*)\"$")
	public void request_field_is(String requestField, String value){
		ReqBody.put(requestField, value);
	}

	@When("^\"([^\"]*)\" is called$")
	public void is_called(String resposneClass){
		RequestSpecification request = RestAssured.given();
		request.body(ReqBody.toJSONString());
		System.out.println("****Request of "+ resposneClass+"****");
		System.out.println(ReqBody.toJSONString());
		
		String endPnt =resposneClass + ".uri";
		String endPntUri = (String) endPointMap.get(endPnt);
		Response = request.post(endPntUri);
		System.out.println("****Respones of "+ resposneClass+"****");
		System.out.println(Response.prettyPrint());
	}

	@Then("^gets a successful response$")
	public void gets_a_successful_response(){
		StatusCode = String.valueOf(Response.getStatusCode());
		Assert.assertEquals(StatusCode, "200");
	}
	
	@And("^the response field \"([^\"]*)\" is \"([^\"]*)\"$")
	public void the_response_field_is(String ResponseField, String value) throws Throwable {
		String resField = Response.jsonPath().get(ResponseField);
		Assert.assertEquals(resField,value);
	}
	
	@AfterClass
	public static void tearDown() {

//		Result result = JUnitCore.runClasses(VSMTestRunner.class);
//		for(Failure failed : result.getFailures()) {
//			System.out.println(failed.toString());
//		}
//		System.out.println(result.wasSuccessful());
		
		
		
	}
	
}