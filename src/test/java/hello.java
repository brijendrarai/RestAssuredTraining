import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

public class hello {
	public static void main(String[] args) {
		String division = "ECOSURE";
		
		//ArrayList<String> list =  jresponse.get(i).get("isDraft").asList();
		ArrayList<String> list = new ArrayList<>();
		list.add("ABC");
		list.add("xyz");
		list.add("ECOSURE1");
		System.out.println(list);
		
		boolean hasDivision = list.contains(division);
		assertEquals(hasDivision, true, ""+division+" not present in response");
		
		
		
	
	}

}
