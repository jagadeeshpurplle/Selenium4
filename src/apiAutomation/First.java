package apiAutomation;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class First {
	
	@Test()
	public void hello3() {
		System.out.println("hello");
	}
	@Test(priority = 1)
	public void hello1() {
		System.out.println("hello");
	}@Test(priority = 2)
	public void hello2() {
		System.out.println("hello");
	}
	@Test()
	public void hello4() {
		System.out.println("hello");
	}
	
	
	@Test(priority = 0, enabled = false)
	public void test() throws UnsupportedEncodingException, IOException {
				
		//base url or host
		RestAssured.baseURI="http://216.10.245.166";
		
		given().param("", "")
				.body("")
				.when()
				.get("")
				.then().extract();
	
		Response res=	given().
				queryParam("key","qaclick123").
				body(postDataJson().toString()).
				when().
				post("/Library/Addbook.php"). 
				then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
		
		System.out.println(prettyJson(res));
		
		JsonObject json = (JsonObject) new JsonParser().parse(res.asString());
	
		System.out.println(json.get("Msg").toString());
	

	}
	
	public JsonObject postDataJson() {
		
		JsonObject json = new JsonObject();
			 
		json.addProperty("name", "Learn Appium Automation with Java");
		json.addProperty("isbn", randomString());
		json.addProperty("aisle", "227");
		json.addProperty("author", "jagadeesh");
		

		return json;
	}
	
	public String randomString() {
//		  String email= RandomStringUtils.randomAlphanumeric(10).toLowerCase();
//		  System.out.println(email);
		  
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder data = new StringBuilder();
		Random rnd = new Random();
		while (data.length() < 5) { // length of the random string.
			int index = (int) (rnd.nextFloat() * chars.length());
			data.append(chars.charAt(index));
		}
		String saltStr = data.toString().toLowerCase();
		return saltStr;

	}

	public String prettyJson(Response res) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(res.asString());
		String prettyJsonString = gson.toJson(je);
//			System.out.println(prettyJsonString);
		return prettyJsonString;
	}
}
