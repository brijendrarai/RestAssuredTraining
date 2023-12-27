package day6;

import java.util.Arrays;
import java.util.HashMap;

public class Place {
	HashMap<String, String> location;
	int accuracy;
	String name;
	String phone_number;
	String address;
	String[] types;
	String website;
	String language;
	
	
	
	public HashMap<String, String> getLocation() {
		return location;
	}
	public void setLocation(HashMap<String, String> location) {
		this.location = location;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String[] getTypes() {
		return types;
	}
	public void setTypes(String[] types) {
		this.types = types;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	@Override
	public String toString() {
		return "Place [location=" + location + ", accuracy=" + accuracy + ", name=" + name + ", phone_number="
				+ phone_number + ", address=" + address + ", types=" + Arrays.toString(types) + ", website=" + website
				+ ", language=" + language + "]";
	}
	
	
}
