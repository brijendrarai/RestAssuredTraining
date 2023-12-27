PostMan session

======================================================
                        Day 1
======================================================
RestAssured
--------------------
RestAssured library is used to automate RestAPIs

Pre-requisites:
--------------------
Java 9+ and eclipse
TestNG
Maven

https://rest-assured.io/
getting started

dependencies
-------------------
rest-assured
json-path
json
gson
testng
scribejava-api    - to generate randon test data
json-schema-validator
xml-schema-validator

static imports
------------------
io.restassured.RestAssured.*
io.restassured.matcher.RestAssuredMatchers.*
org.hamcrest.Matchers.*

or Json Schema
io.restassured.module.jsv.JsonSchemaValidator.*


http request
----------------
get 
post
put
delete

given()
	prerequisite
		content-type, set cookies, ad auth, add param, set headers info etc.
when()
    request
    	get, post, put, delete
then()
	validation
		validate status code, extract response, extract headers cookies and response body

*****************************
https://reqres.in/
*****************************

Get users
----------
https://reqres.in/api/users/2

Post users:
------------
https://reqres.in/api/users
{
    "name": "morpheus",
    "job": "leader"
}

put ruquest: update users
-----------------------------
https://reqres.in/api/users/2
{
    "name": "morpheus",
    "job": "zion resident"
}

delete user
--------------
https://reqres.in/api/users/2



======================================================
                        Day 2
======================================================
 Creating Post Request Payloads in Multiple Ways
 
 How many ways we create request body
 1) Post request body using HashMap   (not recomemded)
 2) Post request body using using org.json   (not recomemded)
 3) Post request body using using POJO
 4) Post request body using using external json file
 
 1) Post request body using HashMap
 {
    "location": {
        "lat": -38.383494,
        "lng": 33.427362
    },
    "accuracy": 50,
    "name": "Frontline house",
    "phone_number": "(+91) 983 893 3937",
    "address": "29, side layout, cohen 09",
    "types": [
        "shoe park",
        "shop"
    ],
    "website": "http://google.com",
    "language": "French-IN"
}

code
--------- 


======================================================
                        Day 3
======================================================
1. Path and Query Parameter
		https://reqres.in/api/users?page=2
		here
			https://reqres.in/api/  Domain
			users					Path
			page=2					parameter
			
2. cookies and headers
	
3. Headers
	Header	headername : value
	Headers
4. logs

======================================================
                        Day 4
======================================================
Parsing Response body || JSON Object
Approach1 
-------------
.then()
	.statusCode(200)
	.header("Content-Type", "application/json; charset=utf-8")
	.body("book[3].title", equalTo("This is my book"));
	
Approach2
------------
Response res = given()
				.contentType("ContentType.JSON")
			.when()
				.get();
				
Assert.assertEquals(res.getStatusCode(), 200);
String bookName = res.jsonPath().get("book[3].title).toString();


//other
loop through json object
upload file and download file


======================================================
                        Day 5
======================================================
ParsingXML Response
-------------------
http://restapi.adequateshop.com/api/Traveler?page=1
http://restapi.adequateshop.com/swagger/ui/index


File upload || download
-------------------------
refer day 5 code block

======================================================
                        Day 6
======================================================
JSON/XML schema validation

Response validations --data
Schema validation - type of data

Json Response ---> json schema 
{
    "book" :[
        {
            "author" : "Angel",
            "category" : "reference",
            "price" : 10.90,
            "title" : "Ancient India"
        },
        {
            "author" : "Brook",
            "category" : "fiction",
            "price" : 9.85,
            "title" : "My dream girl"
        },
        {
            "author" : "Clark",
            "category" : "science",
            "price" : 30.50,
            "title" : "Marsh mission"
        },
        {
            "author" : "Dojo",
            "category" : "general",
            "price" : 70.00,
            "title" : "Money mind"
        }
        
        ]
}

//https://jsonformatter.org/json-to-jsonschema

{
    "$schema": "http://json-schema.org/draft-06/schema#",
    "$ref": "#/definitions/Welcome10",
    "definitions": {
        "Welcome10": {
            "type": "object",
            "additionalProperties": false,
            "properties": {
                "book": {
                    "type": "array",
                    "items": {
                        "$ref": "#/definitions/Book"
                    }
                }
            },
            "required": [
                "book"
            ],
            "title": "Welcome10"
        },
        "Book": {
            "type": "object",
            "additionalProperties": false,
            "properties": {
                "author": {
                    "type": "string"
                },
                "category": {
                    "type": "string"
                },
                "price": {
                    "type": "number"
                },
                "title": {
                    "type": "string"
                }
            },
            "required": [
                "author",
                "category",
                "price",
                "title"
            ],
            "title": "Book"
        }
    }
}


Serialization       pojo --->json
de-serialization    json ---->pojo

Body(json) -----> Request------->Response(json)

Pojo 

maven requied
jaction - if using older version of restassured

======================================================
                        Day 7
======================================================
Authorizations
---------------
authentication - valid credentials or not
authorization - only authentication user will get access to resources

Basic
Digest
Preemptive

Bearer token
auth 1.0 2.0
api key

----------------------------
java faker api

https://github.com/DiUS/java-faker
<dependency>
    <groupId>com.github.javafaker</groupId>
    <artifactId>javafaker</artifactId>
    <version>1.0.2</version>
</dependency>

---------------------------
JSON Object {  }

JSON Array  [   ]

JSON element 

======================================================
                        Day 8
======================================================
Chaining
	Get data from one request and send this data to other request
	
GoRestapi
	createuser -> getuser -> update user -> delete user
	
exercise
https://petstore.swagger.io/
http://restapi.adequateshop.com/swagger/ui/index#!/Traveler/Traveler_Post

===================================================
framework
========================
maintain all project related file

objectives
--------------
1. reusability
2. maintainability
3. readability

Hybrid driven

phases
---------------
1. understand requirements
		- functional specification
		- swagger
2. choose automation tool

==============================================

response.then().log().all()

@Test(priority =1, dataProvider = "data", dataProviderClass=DataProvider.class)
public void testPostUser(String userId, String userName, String fname, ....) these variable should be in secuence as referred in dataprovider array



Genereate extent reports
=================================
Extent reportutility
testng.xml file

<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
<dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
    <version>5.0.9</version>
</dependency>

create ExtentReportManager class and define all method as per documetation
now create testng.xml file and add listener as follows

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="PetSuite">
<listeners>
	<listener class-name="api.utility.ExtentReportManager"></listener>
</listeners>
  <test thread-count="5" name="PetTest">
    <classes>
      <class name="day3.CookiesDemo"/>
      <class name="day3.LoggingDemo"/>
      <class name="day3.HeadersDemo"/>
      <class name="day3.PathAndQueryParameters"/>
    </classes>
  </test> <!-- PetTest -->
</suite> <!-- PetSuite -->


======================================
add logs	
	apache log4j2 dependency
	log4j2.xml file this should be part of src/test/resources
	
	<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>2.2</version>
  </dependency>
  <dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.2</version>
  </dependency>
	
	public Logger logger= LogManager.getLogger(this.getClass());

		logger.info("getting cookes from google.com");

============================================================================
where to write api url 
==========================================
Routes.java
routes.properties //in src/test/resources

create a property file and add data
write a class to read propperties file
import java.util.ResourceBundle;

public class UserEndPoint {

	//method created for getting URL's from properties file
	public static ResourceBundle getUrl() {
		ResourceBundle routes = ResourceBundle.getBundle("routes");//Load properties file
		return routes;
	}
}

use this method anywhere in project
String geturl = UserEndPoint.getUrl().getString("googleurl");

======================================================================
run our tests from command prompt or from jenkins
======================================================================
need to add 2 plugins first

	<build>
		<pluginManagement>
			<plugins>
				<!-- this required to run our app from command prompt of
				jenkins-->
				<plugin>
					<groupId>org.apache.maven.plugins</groupId>
					<artifactId>maven-surefire-plugin</artifactId>
					<version>3.2.3</version>
					<configuration>
						<!-- put your configurations here -->
						<suiteXmlFiles>
							<suiteXmlFile>testng.xml</suiteXmlFile>
						</suiteXmlFiles>
					</configuration>
				</plugin>
				<plugin>
					<groupId>org.apache.maven.plugins</groupId>
					<artifactId>maven-compiler-plugin</artifactId>
					<version>3.12.1</version>
					
				</plugin>
			</plugins>
		</pluginManagement>
	</build>

right click to pom.xml and run as maven test

=> run from command prompt
	install maven first
	 extract
		go to bin folder and set this path in environment variable
		(make sure your JAVA_HOME is configured properly)
		mvn -version from command prompt
		now go to the project directory and run
		mvn test
		
============================================
if you are getting error with java version compatibility add this configuration to maven-compiler-plugin plugin
<configuration>
	<source>10</source>
	<target>10</target>
</configuration>
=======================================================
		Git
=======================================================
git init

git config --global user.name "brij"
git config --global user.email "brijendra@gmail.com"

git status

git add -A  add all the file
git add fileName
git add *.java
git add foldername

git commit -m "this is initial commit"

push the code to remote repository
git remote add origin "git repository url" (local repo to remote repo) one time only

git push -u origin branch_name

====================================================
https://github.com/pavanoltraining/PetStoreAutomation.git


===========================================================
			Jenkins
===========================================================
download jenkins
run it

http://localhost:8080
get admin password from C:\ProgramData\Jenkins\.jenkins\secrets\initialAdminPassword

create first admin user
Username: brijendrarai
Password: Welcome@12345
fullname: Brijendra rai
email: brijendrarai1990@gmail.com

Now check java path set correctly or not
Manage Jenkins ->  Tools
 add jdk
 set git path
 

** create an application to test all above feature with file upload feature
