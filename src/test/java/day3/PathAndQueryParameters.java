package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PathAndQueryParameters {
	
	@Test
	public void testQueryAndPathParameters()
	{
		RestAssured.baseURI = "https://reqres.in";
		//https://reqres.in/api/users?page=2&id=5
		given()
			.pathParam("mypath", "users")	//path parameter
			.queryParam("page", 2)			//query parameter
			.queryParam("id", 5)			//query parameter
		
		.when()
			.get("/api/{mypath}")
		
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
}
