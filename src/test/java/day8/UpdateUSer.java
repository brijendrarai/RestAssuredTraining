package day8;

import static io.restassured.RestAssured.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUSer {
	@Test
	void test_updateUser(ITestContext context) {
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("gender","Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		
		String bearerToken = "5db0bc256c3b150eb7fbb4a4b6172f7ac28c879f237c3c7786b89d8495ed004b";
		int id = (Integer)context.getAttribute("user_id");
		//Response res =  
		given()
			.headers("Authorization", "Bearer "+bearerToken)
			.contentType("application/json")
			.pathParam("id", id)
			.body(data.toString())
		.when()
			.put("https://gorest.co.in/public/v2/users")
		.then()
		.statusCode(200)
		.log().all();
	}

}
