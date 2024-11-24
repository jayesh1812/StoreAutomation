package api.endpoints;

import static io.restassured.RestAssured.given;
import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {

	public static Response createUser(String payload){
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(Routes.post_URL);

		return response;
	}

	public static Response getUser(String actualUsername){
		Response response = given()
				.pathParam("username", actualUsername)
				.when()
				.get(Routes.get_URL);

		return response;
	}

	public static Response putUser(String updateUsername, String payload){
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", updateUsername)
				.body(payload)
				.when()
				.put(Routes.put_URL);

		return response;
	}

	public static Response deleteUser(String username){
		Response response = given()
				.pathParam("username", username)
				.when()
				.delete(Routes.delete_URL);
		
		return response;
	}
}
