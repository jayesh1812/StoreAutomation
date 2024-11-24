package api.test;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.Routes;
import api.endpoints.UserEndpoints;
import api.utilities.ResusableComp;
import io.restassured.response.Response;

public class UserTests extends ResusableComp{

	@Test(priority=1)
	public void testPostUser() throws IOException {

		Response response =  UserEndpoints.createUser(readAPIFromTextFile(Routes.userPostTemp));
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority=2)
	public void testGetUser() throws IOException {

		Response response =  UserEndpoints.getUser("James.miller");
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void testUpdateUser() throws IOException {

		Response response =  UserEndpoints.putUser("James.miller",readAPIFromTextFile(Routes.userPostTemp)
				.replace("retryyyy", "newPasscode")
				.replace('[', ' ')
				.replace(']', ' '));
		System.out.println(response.statusCode());
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
		
		Response responseAfterUpdate =  UserEndpoints.getUser("James.miller");
		responseAfterUpdate.then().log().all();

		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
	}
	
	@Test(priority=3)
	public void testDeleteUser() {
		Response response = UserEndpoints.deleteUser("James.miller");
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
}
