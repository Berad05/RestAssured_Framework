package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {


	public AddPlace addPlaceApi(String name,String address,String language)
	{
		AddPlace addplace=new AddPlace();
		addplace.setAccuracy("50");
		addplace.setAddress(address);
		addplace.setLanguage(language);
		addplace.setName(name);
		addplace.setPhone_number("9028699756");
		addplace.setWebsite("https://www.google.com");
		List<String> types=new ArrayList<String> ();
		types.add("Shop");
		types.add("Hospital");
		addplace.setTypes(types);
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		addplace.setLocation(l);
		return addplace;
	}
	
	
	public String DeletePlaceApiPayload(String place_id)
	{
		  return"{ \"place_id\":\""+place_id+"\"   \t \r\n}\r\n";
	}
}
