package api.activityURL;

public class crudURLs {

	public static String baseURI = "https://fakerestapi.azurewebsites.net/api/v1/Activities";
	
	public static String postURI = baseURI;
	public static String getURI = baseURI+"/{actID}";
	public static String putURI = baseURI+"/{actID}";
	public static String deleteURI = baseURI+"/{actID}";
}
