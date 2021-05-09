package resources;

public enum APIResources {


	AppPlaceApi("/maps/api/place/add/json"),
	GetPlaceApi("/maps/api/place/get/json"),
	DeletePlaceApi("/maps/api/place/delete/json"),
	UpdatePlaceApi("/maps/api/place/update/json");
	private String resourceName;
	
	APIResources(String resourceName)
	{
		this.resourceName=resourceName;
	}
	
	public String getResource()
	{
		return resourceName;
	}
}
