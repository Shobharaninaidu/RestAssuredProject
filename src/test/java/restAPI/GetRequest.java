package restAPI;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {
	@Test
	public void test1() {

		RestAssured.baseURI = "http://localhost:3000/employees";

		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		String responseBody = response.body().asString();
		System.out.println(responseBody);
		System.out.println("Response code is : " + response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);

		// print all the names coming in the response

		JsonPath json = response.jsonPath();
		List<String> names = json.get("name");
		for (String name : names) {
			System.out.println(name);
		}
		System.out.println("The second name is " + names.get(1));
		System.out.println("The third name is " + names.get(2));
	}
}
