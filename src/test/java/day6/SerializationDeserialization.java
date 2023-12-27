package day6;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import day2.pojo.Place;

//Pojo  ----> JSON Object ----> Pojo
public class SerializationDeserialization {

	//@Test
	public void convertPojoToJson() throws JsonProcessingException
	{
		//created java object using pojo class
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
		
		//convert java object -->json object
		ObjectMapper objMapper = new ObjectMapper();
		String jsonData = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		System.out.println(jsonData);
		
	}
	@Test
	public void convertJsonToPojo() throws JsonProcessingException
	{
		String jsondata = "{\r\n"
				+ "  \"location\" : {\r\n"
				+ "    \"lng\" : \"33.427362\",\r\n"
				+ "    \"lat\" : \"-38.383494\"\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\" : 50,\r\n"
				+ "  \"name\" : \"Frontline House\",\r\n"
				+ "  \"phone_number\" : \"(+91) 987 654 3210\",\r\n"
				+ "  \"address\" : \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\" : [ \"shoe park\", \"shop\", \"sandles\" ],\r\n"
				+ "  \"website\" : \"https://google.com\",\r\n"
				+ "  \"language\" : \"French-IN\"\r\n"
				+ "}";
		
		ObjectMapper objMapper = new ObjectMapper();
		Place place = objMapper.readValue(jsondata, Place.class);
		System.out.println(place.getAddress());
	}
	
}
