package api.activityURL;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import com.github.dockerjava.transport.DockerHttpClient.Response;

import api.Payload.activityPOJO;
import io.restassured.http.ContentType;

public class CRUDOperations {

	public static Response postActivity(activityPOJO Payload)
	{
		Response response = (Response) given()
		 .contentType(ContentType.JSON)
		 .body(Payload)
		 
		.when()
		 .post(crudURLs.postURI);
		
		return response;
		
	}
	
	public static Response getActivity(int actID)
	{
		Response response = (Response) given()
				.contentType(ContentType.JSON)
				.pathParam("actID", actID)
		
		.when()
		 .get(crudURLs.getURI);
		
		return response;
	}
	
	public static Response putActivity(int actID, activityPOJO Payload)
	{
		Response response = (Response) given()
				.contentType(ContentType.JSON)
				.pathParam("actID", actID)
				.body(Payload)
				
			.when()
			 .put(crudURLs.putURI);
		
		return response;
	}
	
	public static Response deleteActivity(int actID)
	{
		Response response = (Response) given()
				.contentType(ContentType.JSON)
				.pathParam("actID", actID)
				
			.when()
			 .delete(crudURLs.deleteURI);
				
		return response;
	}
}
