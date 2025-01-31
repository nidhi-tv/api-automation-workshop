import clients.UserClient;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.response.SignupResponseModel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class UserSignUpTest extends BaseAPITest {
    @Test
    public void successfulRegistration(){
        String email = UUID.randomUUID().toString() + "@ultralesson.com"; // "joseph11@gmail.com";
        String password = "joseph@123";

        UserClient userClient = new UserClient();
        SignupResponseModel response = userClient.createUser(email, password);

        String authenticatedEmail = response.getData().getUser().getEmail();
        String role =  response.getData().getUser().getRole();
        String accessToken =response.getData().getSession().getAccessToken();

        System.out.println(accessToken);
        // without pojo lombok
//        int statusCode = response.getStatusCode();
//        String authenticatedEmail =  response.jsonPath().get("data.user.email");
//        String role =  response.jsonPath().get("data.user.role");
//        String accessToken = response.jsonPath().get("data.session.access_token");
        // without pojo lombok

        // Assert
//        Assert.assertEquals(statusCode, 201, "Failed due to wrong status code");

        Assert.assertEquals(authenticatedEmail, email, "Failed due to incorrect email");
        Assert.assertEquals(role, "authenticated", "Failed to validate the role");
        Assert.assertNotNull(accessToken, "Failed as access token is null");

    }
}
