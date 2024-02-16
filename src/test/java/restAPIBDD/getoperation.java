package restAPIBDD;

import io.restassured.RestAssured;

public class getoperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String BaseURI = "http://localhost:3000/employees";
		RestAssured.given().baseUri(BaseURI).when().get().then().log().body().statusCode(200);
	}

}
