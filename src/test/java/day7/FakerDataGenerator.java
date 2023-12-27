package day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator {
	
	@Test
	public void testGenerateFakeData() {
		Faker faker = new Faker();
		String fullname = faker.name().fullName();
		System.out.println(fullname);
	}
}
