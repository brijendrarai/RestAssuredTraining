package api.endpoints;

import java.util.ResourceBundle;

public class UserEndPoint {

	//method created for getting URL's from properties file
	public static ResourceBundle getUrl() {
		ResourceBundle routes = ResourceBundle.getBundle("routes");//Load properties file
		return routes;
	}
}
