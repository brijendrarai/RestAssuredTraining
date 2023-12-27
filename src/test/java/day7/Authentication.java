package day7;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Authentication {
	//@Test
	public void testBasicAuthentication() {
		given()
			.auth().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	//@Test
	public void testDigestAuthentication() {
		given()
			.auth().digest("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	//@Test
	public void testPreemptiveAuthentication() {
		given()
			.auth().preemptive().basic("postman", "password")
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	//@Test
	void testBearerTokenAuthentication()
	{
		String bearerToken = "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";
		given()
			.headers("Authorization", "Bearer "+ bearerToken)
		.when()
		.get("https://api.github.com/user/repos")
	.then()
		.statusCode(200)
		.log().all();
	}
	
	//@Test
	void testOAuth1Authentication() {
		given()
			.auth().oauth("consumerKey", "consumerSecret", "accessToken", "tokenSecret")
		.when()
			.get("url")
		.then()
			.statusCode(200)
			.log().all();
	}
	//@Test
	void testOAuth2Authentication() {
		given()
			.auth().oauth2("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")
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	void testApiKeyAuthentication() {
		given()
			.queryParam("appid", "55e70390cce0987757f9cc1f09e40d71")
		.when()
			.get("http://api.openweathermap.org/data/2.5/air_pollution?lat=50&lon=50")
		.then()
			.statusCode(200)
			.log().all();
	}

}
