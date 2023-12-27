package day2;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import day2.pojo.Place;
import io.restassured.RestAssured;
/*
 How many ways we create request body
 1) Post request body using HashMap   (not recomemded)
 2) Post request body using using org.json   (not recomemded)
 3) Post request body using using POJO
 4) Post request body using using external json file
 
 * */

public class DiffWaysToCreateRequestBody {

	// 1) Post request body using HashMap (not recomemded)
	// @Test
	void testPostusingHashMap() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";

		HashMap<String, Object> data = new HashMap<String, Object>();

		HashMap<String, String> location = new HashMap<String, String>();
		location.put("lat", "-38.383494");
		location.put("lng", "33.427362");

		data.put("location", location);
		data.put("accuracy", 50);
		data.put("name", "Frontline House");
		data.put("phone_number", "(+91) 987 654 3210");
		data.put("address", "29, side layout, cohen 09");

		String types[] = { "shoe park", "shop", "sandles" };
		data.put("types", types);

		data.put("website", "https://google.com");
		data.put("language", "French-IN");

		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(data)

				.when().post("maps/api/place/add/json").then().statusCode(200).body("scope", equalTo("APP"))
				.header("server", "Apache/2.4.52 (Ubuntu)")
				/*
				 * .body("name", equalTo("Frontline House")) .body("phone_number",
				 * equalTo("(+91) 987 654 3210")) .body("types[0]", equalTo("shoe park"))
				 * .body("types[1]", equalTo("shop"))
				 */
				.extract().response().asString();

		System.out.println("response: " + response);

	}

	// 2) Post request body using org.json library
	/*
	 * Prerequisite library to add
	 * <dependency>
			<groupId>org.json</groupId>
			<artifactId>json</artifactId>
			<version>20230227</version>
		</dependency>
	 * 
	 */
	//@Test
	public void testPostUsingJsonLibrary() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";

		HashMap<String, String> location = new HashMap<String, String>();
		location.put("lat", "-38.383494");
		location.put("lng", "33.427362");

		JSONObject data = new JSONObject();
		data.put("location", location);
		data.put("accuracy", 50);
		data.put("name", "Frontline House");
		data.put("phone_number", "(+91) 987 654 3210");
		data.put("address", "29, side layout, cohen 09");
		String types[] = { "shoe park", "shop", "sandles" };
		data.put("types", types);

		data.put("website", "https://google.com");
		data.put("language", "French-IN");
		System.out.println("data: "+data.toString());
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.contentType("application/json")
				.body(data.toString())

				.when().post("maps/api/place/add/json").then().statusCode(200).body("scope", equalTo("APP"))
				.header("server", "Apache/2.4.52 (Ubuntu)")
				.extract().response().asString();

		System.out.println("response: " + response);
	}
	
	// 2) Post request body using POJO class
		//@Test
		public void testPostUsingPOJOClass() {
			RestAssured.baseURI = "https://rahulshettyacademy.com";
			Place data = new Place();
			HashMap<String, String> location = new HashMap<String, String>();
			location.put("lat", "-38.383494");
			location.put("lng", "33.427362");

			data.setLocation(location);
			data.setAccuracy(50);
			data.setName("Frontline House");
			data.setPhone_number("(+91) 987 654 3210");
			data.setAddress("29, side layout, cohen 09");
			
			String types[] = { "shoe park", "shop", "sandles" };
			data.setTypes(types);
			data.setWebsite("https://google.com");
			data.setLanguage("French-IN");
			
			System.out.println("data: "+data.toString());
			String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
					.contentType("application/json")
					.body(data)

					.when().post("maps/api/place/add/json").then().statusCode(200).body("scope", equalTo("APP"))
					.header("server", "Apache/2.4.52 (Ubuntu)")
					.extract().response().asString();

			System.out.println("response: " + response);
		}
		
		//4) Post request body using using external json file
				@Test
				public void testPostUsingExternalJsonFile() throws FileNotFoundException {
					RestAssured.baseURI = "https://rahulshettyacademy.com";
					FileReader fr = new FileReader(new File(".//place.json"));
					JSONTokener jt = new JSONTokener(fr);
					JSONObject data = new JSONObject(jt);
					
					System.out.println("data: "+data.toString());
					String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
							.contentType("application/json")
							.body(data.toString())

							.when().post("maps/api/place/add/json").then().statusCode(200).body("scope", equalTo("APP"))
							.header("server", "Apache/2.4.52 (Ubuntu)")
							.extract().response().asString();

					System.out.println("response: " + response);
				}

}
