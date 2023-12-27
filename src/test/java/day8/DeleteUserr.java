package day8;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DeleteUserr {
	@Test
	public void test_deleteUser(ITestContext context) {
		String bearerToken = "5db0bc256c3b150eb7fbb4a4b6172f7ac28c879f237c3c7786b89d8495ed004b";
		int id =(Integer)context.getAttribute("user_id");;
		
		given()
			.header("Authorization", "Bearer "+bearerToken)
			.pathParam("id", id)
		.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
		.then()
			.statusCode(200)
			.log().all();
	}

}
