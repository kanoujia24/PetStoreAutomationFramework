package api.test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.github.javafaker.Faker;

import api.endpoint.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {
	Faker fr;
	User Upayload;
	@BeforeClass
	public void setData() {

		fr=new Faker();
		Upayload=new User();
		
		Upayload.setId(fr.idNumber().hashCode());
		Upayload.setUsername(fr.name().username());
		Upayload.setFirstname(fr.name().firstName());
		Upayload.setLastname(fr.name().lastName());
		Upayload.setEmail(fr.internet().safeEmailAddress());
		Upayload.setPhone(fr.phoneNumber().cellPhone());
		Upayload.setPassword(fr.internet().password());
	}
	
	//calling method create user from UserEndPoint class
	
	@Test(priority=1)
	public void testPostUser() {
		 Response res=UserEndPoints.creatUser(Upayload);
		 res.then().log().all();
	}
	
@Test(priority=2)
public void testGetUser() {
	Response res=UserEndPoints.getUser(this.Upayload.getUsername());
	res.then().log().all();
	Assert.assertEquals(res.getStatusCode(), 200);
}
@Test(priority=3)
public void testUpdateUser() {
	
	//update only firstname, lastname and email
	Upayload.setFirstname(fr.name().firstName());
	Upayload.setLastname(fr.name().lastName());
	Upayload.setEmail(fr.internet().safeEmailAddress());
	
	Response res=UserEndPoints.updateUser(Upayload, this.Upayload.getUsername());
	res.then().log().body();
	
	//checking data after update
	Response res1=UserEndPoints.getUser(this.Upayload.getUsername());
	Assert.assertEquals(res1.getStatusCode(), 200);
}

@Test(priority=4)
public void testDeleteUser() {
	Response res=UserEndPoints.deleteUser(this.Upayload.getUsername());
	Assert.assertEquals(res.getStatusCode(),200);
}
}
