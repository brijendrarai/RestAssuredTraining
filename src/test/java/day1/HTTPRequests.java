package day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

/*
given()
	prerequisite
		content-type, set cookies, ad auth, add param, set headers info etc.
when()
    request
    	get, post, put, delete
then()
	validation
		validate status code, extract response, extract headers cookies and response body
*/

public class HTTPRequests {
	int id;
	@Test(priority = 1)
	void getUser() {
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.log().all();		
	}
	
	@Test(priority=2)
	void createUser() {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "Brijendra");
		data.put("job", "trainer");	
		id = given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		//.then()
		//	.statusCode(201)
		//	.log().all();
		System.out.println("********* id= "+id);		
	}
	
	@Test(priority=3, dependsOnMethods = {"createUser"})
	void updateUser() {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "Brijendra Rai");
		data.put("job", "trainer");		
		given()
				.contentType("application/json")
				.body(data)		
		.when()
			.put("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority = 4, dependsOnMethods = {"createUser"})
	void deleteUser() {
		given()
		.when()
			.delete("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(204)
			.log().all();	
	}	
}
