package day3;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoint;
import io.restassured.response.Response;

public class CookiesDemo {
	public Logger logger= LogManager.getLogger(this.getClass());
	//@Test
	public void testCookies()
	{
		String geturl = UserEndPoint.getUrl().getString("googleurl");
		logger.info("getting cookes from google.com");
		given()
		.when().get(geturl)
		.then()
		.cookie("AEC", "Ackid1SBDMpV34YNWmBdiKiQGDDM646yVwBpWJyFY7uNdmcHhb3-EpX_OTs")
		.log().all();
		logger.info("cookies collected");
	}
	
	@Test
	public void getCookiesInfo()
	{
		String geturl = UserEndPoint.getUrl().getString("googleurl");

		Response response = given()
		.when()
			.get(geturl);
		//get single cookie info
		String cookieValue = response.getCookie("AEC");
		System.out.println("AEC: "+ cookieValue);
		
		//get all cookies info
		Map<String, String> cookies = response.getCookies();
		for(Entry entry : cookies.entrySet()) {
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		logger.info("cookies collected in method 2");
	}

}
