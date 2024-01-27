package clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserClient {
    public Response createUser(String email, String password){

        //Arrange
        String signupEndpointResource = "/api/auth/signup";

        String signupRequestBody = String.format("{\"email\":\"%s\", \"password\":\"%s\"}", email, password);

        //Act
        Response signUpResponse = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(signupRequestBody)
                .post(signupEndpointResource);

        return signUpResponse;
    }
}
