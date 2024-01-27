package clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.request.SignupRequestModel;
import models.response.SignupResponseModel;

public class UserClient {
    public SignupResponseModel createUser(String email, String password){

        //Arrange
        String signupEndpointResource = "/api/auth/signup";

//        String signupRequestBody = String.format("{\"email\":\"%s\", \"password\":\"%s\"}", email, password);
        SignupRequestModel signupRequestBody = SignupRequestModel.builder().email(email).password(password).build();

        //Act
        SignupResponseModel signUpResponse = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(signupRequestBody)
                .post(signupEndpointResource).as(SignupResponseModel.class);

        return signUpResponse;
    }
}
