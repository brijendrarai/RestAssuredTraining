package day3;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class LoggingDemo {
	@Test
	public void testLogs() {
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			//.log().body()
			//.log().headers()
			//.log().cookies()
			.log().everything();
	
	}

}
