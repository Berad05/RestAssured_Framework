package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	
	@Before("@Regression")
	public void addPlace() throws IOException
	{
	   if(stepDefination.place_id==null)
	   {
		   stepDefination m=new stepDefination();
			m.user_is_having_add_place_api_with("Vaibhav", "Ramnagar", "English");
			m.user_calls_with_http_request("AppPlaceApi", "Post");
			m.verify_place_created_maps_to_using_request("Vaibhav","GetPlaceApi");  
	   }
		
	}
}
