package day6;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
public class JSONSchemaValidation {

	@Test
	public void jsonschemavalidation() {
		given()
		.when()
			.get("http://localhost:3000/books")
		.then()
			//below statement is for schema validations
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("bookJSONSchema.json"));
	}
}
