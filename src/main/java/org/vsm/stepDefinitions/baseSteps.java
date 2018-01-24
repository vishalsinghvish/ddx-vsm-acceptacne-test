package org.vsm.stepDefinitions;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

public class baseSteps extends PropertyReader {
	
	PropertyReader pr = new PropertyReader();
	static JSONObject ReqBody = new JSONObject(); 
	static String StatusCode = "statusCode";
	static Response Response;

	@Given("^a maximal request \"([^\"]*)\"$")
	public void a_maximal_request(String requestWrapper){
		propertyMap = pr.ReadPropertyFile("environment.properties");
		RestAssured.baseURI = (String) propertyMap.get(requestWrapper);
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
		propertyMap = pr.ReadPropertyFile("endpoint.properties");
		String endPnt =resposneClass + ".uri";
		String endPntUri = (String) propertyMap.get(endPnt);
		Response = request.post(endPntUri);
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
	
}