package Day5;

import java.io.File;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class UploadFile {
	
	@Test
	public void singleFileUpload()
	{
		File myfile = new File("C:\\AutomationPractice\\Test1.txt");
		
		given()
			.multiPart("file",myfile)
			.contentType("multipart/form-data")
		.when()
			.post("http://localhost:8080/uploadFile")
		.then()
			.statusCode(200)
			.body("fileName", equalTo("Test1.txt"))
			.log().all();
	}
	@Test
	public void multipleFileUpload()
	{
		File myfile1 = new File("C:\\AutomationPractice\\Test1.txt");
		File myfile2 = new File("C:\\AutomationPractice\\Test2.txt");
		
		given()
			.multiPart("files",myfile1)
			.multiPart("files",myfile2)
			.contentType("multipart/form-data")
		.when()
			.post("http://localhost:8080/uploadMultipleFiles")
		.then()
			.statusCode(200)
			.body("[0].fileName", equalTo("Test1.txt"))
			.body("[1].fileName", equalTo("Test2.txt"))
			.log().all();
	}
	
	@Test
	public void multipleFileUpload1()//not work for all kind of api
	{
		File myfile1 = new File("C:\\AutomationPractice\\Test1.txt");
		File myfile2 = new File("C:\\AutomationPractice\\Test2.txt");
		
		File fileArr[] = {myfile1, myfile2};
		given()
			.multiPart("files",fileArr)
			.contentType("multipart/form-data")
		.when()
			.post("http://localhost:8080/uploadMultipleFiles")
		.then()
			.statusCode(200)
			.body("[0].fileName", equalTo("Test1.txt"))
			.body("[1].fileName", equalTo("Test2.txt"))
			.log().all();
	}
	
	@Test
	void fileDownload() {
		given()
		.when()
			.get("http://localhost:8080/downloadFile/Test1.txt")
		.then()
			.statusCode(200)
			.log().body();
	}



}
