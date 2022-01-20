package apiAutomation;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Walmart {

	JsonObject respons;
	
	@Test(priority = 1)
	public void createUSer() {
		
		RestAssured.baseURI = "https://reqres.in";

		
		Response response = given()
								.body(getData())
								.post("/api/users").then().extract().response();

		System.out.println("PostResponse \n"+response.asString());
		respons = (JsonObject) new JsonParser().parse(response.asString());
		
	}
	
	
	@Test(priority = 2)
	public void getUser() {
		
		String id = respons.get("id").getAsString();
		
		RestAssured.baseURI = "https://reqres.in";
		
		Response response= given().get("/api/user/"+id)
					.then().extract().response();
	
		JsonObject getResponse = (JsonObject)new JsonParser().parse(response.asString());
		
		System.out.println("GetResponse \n"+getResponse);
		JsonObject dataObject = getResponse.get("data").getAsJsonObject();
		
		String resultId = dataObject.get("id").getAsString();
		System.out.println(resultId);
	}
	
	
	public String getData() {
		
		String name = "jagadeesh";
		String job = "sdet";
	    return "{\"name\": "+name+",\"job\": "+job+"}";
	}
}
