package restAPIBDD;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class APIOperationsTest {

	String BaseURI = "http://localhost:3000/employees";

	@Test
	public void GetOperation() {
		RestAssured.given().baseUri(BaseURI).when().get().then().log().body().statusCode(200);
	}

	@Test
	public void GetOperationWithPathParams() {
		RestAssured.given().baseUri(BaseURI).when().get("/2").then().log().body().statusCode(200).body("name",
				Matchers.equalTo("David"));
	}

	@Test
	public void GetOperationWithParaQueryParams() {
		RestAssured.given().queryParam("CUSTOMER_ID", "68195").queryParam("PASSWORD", "1234!")
				.queryParam("Account_No", "1").baseUri("https://demo.guru99.com/V4/sinkministatement.php?").when().get()
				.then().log().body().statusCode(200);
	}

	@Test
	public void PostOperationWithHashMap() {

		HashMap<String, String> obj = new HashMap<String, String>();

		obj.put("name", "Shobha");
		obj.put("salary", "15000");
		obj.put("id", "12");

		RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).body(obj).baseUri(BaseURI).when()
				.post().then().log().body().statusCode(201);
	}

	@Test
	public void PutOperation() {

		HashMap<String, String> obj = new HashMap<String, String>();
		obj.put("name", "Shobha");
		obj.put("salary", "20000");
		obj.put("id", "12");

		RestAssured.given().contentType(ContentType.JSON).accept(ContentType.JSON).body(obj).baseUri(BaseURI).when()
				.put("/12").then().log().body().statusCode(200);
	}

	@Test
	public void DeleteOperation() {

		RestAssured.given().baseUri(BaseURI).when().delete("/6").then().log().body().statusCode(200);
	}

}