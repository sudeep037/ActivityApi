package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.Payload.activityPOJO;
import api.activityURL.CRUDOperations;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class CRUDValidations {

	activityPOJO activityPayload;
	Faker faker;
	public static String dueDate = "2023-11-29T05:24:57.454Z";
	
	@BeforeMethod
	public void setUpData()
	{
		activityPayload = new activityPOJO();
		faker = new Faker();
 		
		activityPayload.setId(faker.idNumber().hashCode());
		activityPayload.setTitle(faker.book().title());
		activityPayload.setDueDate(dueDate);		
	}
	
	@Test(priority=1)
	public void testPOSTActivity()
	{
		Response response = (Response) CRUDOperations.postActivity(activityPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);	
		response.then().body("x.id",equalTo(this.activityPayload.getId()));
		
		JSONObject jo = new JSONObject(response.toString());
		
	}
	
	@Test(priority=2)
	public void testGETActivity()
	{
		Response response = (Response) CRUDOperations.getActivity(this.activityPayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void testPUTActivity()
	{
		Response response = (Response) CRUDOperations.putActivity(this.activityPayload.getId(), activityPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=4)
	public void testDELETEActivity()
	{
		Response response = (Response) CRUDOperations.deleteActivity(this.activityPayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
