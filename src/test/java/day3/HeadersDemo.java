package day3;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeadersDemo {
	
	//@Test(priority = 1)
	public void testHeaders() {
		baseURI = "https://www.google.com/";
		given()
		.when()
			.get()
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.and()
			.header("Content-Encoding", "gzip")
			.and()
			.header("Server", "gws")
			.log().all();	
	}
	

	@Test(priority = 1)
	public void getHeaders() {
		baseURI = "https://www.google.com/";
		Response response =  given()
		.when()
			.get()
		;
		//Get single header info
		String headerValue = response.getHeader("Server");
		System.out.println("Header server :"+headerValue);
		
		//get all headers
		//this approach is not recommended as log().all() print all headers in the response
		Headers headers= response.getHeaders();
		for(Header header : headers) {
			System.out.println(header.getName() +" : "+ header.getValue());
		}
	}

}
