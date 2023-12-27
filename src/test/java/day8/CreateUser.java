package day8;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class CreateUser {
	@Test
	void test_createUser(ITestContext context) {
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("gender","Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken = "5db0bc256c3b150eb7fbb4a4b6172f7ac28c879f237c3c7786b89d8495ed004b";
		
		//Response res =  
		int id = given()
			.headers("Authorization", "Bearer "+bearerToken)
			.contentType("application/json")
			.body(data.toString())
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");
		System.out.println("Generated ID :"+ id);
		//context.setAttribute("user_id", id);
		context.getSuite().setAttribute("user_id", id);
	}

}
