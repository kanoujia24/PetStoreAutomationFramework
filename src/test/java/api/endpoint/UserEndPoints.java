package api.endpoint;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
   //for create user
	public static Response creatUser(User payload) {
		Response res=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
	.when()
	     .post(Route.post_url);
		return res;
		}
	
	//for get user
	
	public static Response getUser(String userName) {
		
		Response res=given()
				.pathParam("username", userName)
			.when()
			    .get(Route.get_url);
				
		return res;
	}
	
	//for update user
	
	public static Response updateUser(User payload, String userName) {
		Response res= given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username",userName)
				.body(payload)
		     .when()
		        .put(Route.update_url);
		return res;
	}
	
	//for delete user
	public static Response deleteUser(String userName) {
		Response res =given()
				    .pathParam("username", userName)
		       .when()
		            .delete(Route.delete_url);
		return res;
		
	}
}
