package day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class GetUser {
	@Test
	void test_getUser(ITestContext context) {
		//int id = (Integer) context.getAttribute("user_id");  //this should come from create user request
		int id = (Integer) context.getSuite().getAttribute("user_id");
		System.out.println("GetUser class user_id :"+id);
		String bearerToken = "5db0bc256c3b150eb7fbb4a4b6172f7ac28c879f237c3c7786b89d8495ed004b";
		given()
			.headers("Authorization", "Bearer +"+bearerToken)
			.pathParam("id", id)
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200)
			.log().all();
	}

}
