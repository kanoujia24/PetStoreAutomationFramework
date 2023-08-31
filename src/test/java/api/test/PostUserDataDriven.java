package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoint.UserEndPoints;
import api.payload.User;
import api.utilities.TestDataProvider;
import io.restassured.response.Response;

public class PostUserDataDriven {
	@Test(priority=1,dataProvider="Data",dataProviderClass=TestDataProvider.class)
public void testPostUser(String userId,String uName,String fName,String lName,String email,String pwd,String Phn) {
	User Upayload=new User();
	Upayload.setId(Integer.parseInt(userId));
	Upayload.setUsername(uName);
	Upayload.setFirstname(fName);
	Upayload.setLastname(lName);
	Upayload.setEmail(email);
	Upayload.setPassword(pwd);
	Upayload.setPhone(Phn);
	Response res=UserEndPoints.creatUser(Upayload);
	Assert.assertEquals(res.getStatusCode(), 200);
	}
	@Test(priority=2,dataProvider="userName",dataProviderClass=TestDataProvider.class)
 public void deleteUserByName(String userName) {
	 Response res=UserEndPoints.deleteUser(userName);
	 Assert.assertEquals(res.getStatusCode(), 200);
 }
}
