import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class TryingTest {

    @Before
    public void setup() {
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }


    @Test()
    public void getMyInfoStatusCode() {
        given()
                .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MjAzNmQyY2RjY2Q4YTAwM2RlMTBkYzgiLCJpYXQiOjE3MjY1NTQzMDAsImV4cCI6MTcyNzE1OTEwMH0.JvMDL1gZDYpUyakBa5RiLqYu_lc8a0WJvgk2SeDG0TM")
                .get("/api/users/me")
                .then().statusCode(200)
                .and()
                .body("data.name", equalTo("Denis Sangi"));
    }

//    @Test
//    public void checkUserName() {
//        Response response = given()
//                .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MjAzNmQyY2RjY2Q4YTAwM2RlMTBkYzgiLCJpYXQiOjE3MjY1NTQzMDAsImV4cCI6MTcyNzE1OTEwMH0.JvMDL1gZDYpUyakBa5RiLqYu_lc8a0WJvgk2SeDG0TM")
//                .get("/api/user/me");
//                response.then().assertThat().body("data.name", equalTo("Denis Sangi"));
//        System.out.println(response.body().asString());
//    }

}
