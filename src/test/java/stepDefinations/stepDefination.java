package stepDefinations;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static io.restassured.RestAssured.given;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;

import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import static org.junit.Assert.*;

public class stepDefination extends Utils{

	
	public Response response;
	AddPlace addplace;
	public RequestSpecification request;
	public ResponseSpecification responseSpec;
	
	TestDataBuild data=new TestDataBuild();
	static String place_id;
	@Given("User is having AddPlace Api with {string} {string} {string}")
	public void user_is_having_add_place_api_with(String name, String address, String language) throws IOException {
		request=given().spec(requestSpecifications()).body(data.addPlaceApi(name,address,language));
		
		
	}
	
	
	
	  

@When("User calls {string} with http {string} request")
public void user_calls_with_http_request(String APIResource, String httpRequest) {
	APIResources resourceAPI=APIResources.valueOf(APIResource);
	
	responseSpec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	if(httpRequest.equalsIgnoreCase("post"))
	{
		response=request.when().post(resourceAPI.getResource()).then().spec(responseSpec).extract().response();
	
	}
	else if(httpRequest.equalsIgnoreCase("Get"))
	{
		response=request.when().get(resourceAPI.getResource()).then().spec(responseSpec).extract().response();
	}
	else if(httpRequest.equalsIgnoreCase("Delete"))
	{
		response=request.when().delete(resourceAPI.getResource()).then().spec(responseSpec).extract().response();
	}
	else if(httpRequest.equalsIgnoreCase("Update"))
	{
		response=request.when().delete(resourceAPI.getResource()).then().spec(responseSpec).extract().response();
	}
   
}
@Then("The Api call get success with statusCode {int}")
public void the_api_call_get_success_with_status_code(Integer statucCode) {
	assertEquals(response.getStatusCode(),200);
   
}

@Then("{string} in response body is {string}")
public void in_response_body_is(String key, String expectedValue) {
    
  
    assertEquals(getJsonPath(response,key),expectedValue);


   
}


@Then("verify place created maps to {string} using {string} resource")
public void verify_place_created_maps_to_using_request(String expectedPlaceName, String resourceName) throws IOException {
	place_id=getJsonPath(response,"place_id");
	request=given().spec(requestSpecifications()).queryParam("place_id", place_id);
    user_calls_with_http_request(resourceName, "Get");
    assertEquals(getJsonPath(response,"name"),expectedPlaceName);
	
}


@Given("User is having Delete Place Api")
public void user_is_having_delete_place_api() throws IOException {
	request=given().spec(requestSpecifications()).body(data.DeletePlaceApiPayload(place_id));
}
}
