import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class LoginTest {

    private final User existedUser = new User().getExistedUser();
    private final User incorrectEmailUser = new User().getIncorrectLoginUser();
    private final User incorrectPasswordUser = new User().getIncorrectPasswordUser();


    private final String authorisation = "/auth/login";
    private final String[] header = {"Content-type", "application/json"};

    @Before
    public void setup() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/api";
    }

    private String getAuthenticationToken(User user) {
        Response response =
                given()
                        .header(header[0], header[1])
                        .and()
                        .body(user)
                        .when()
                        .post(authorisation);
        response.then().statusCode(200)
                .and()
                .assertThat().body("accessToken", notNullValue());
        return response.body().path("accessToken").toString();
    }

    @Test
    public void loginAndCheckStatusCodeTest() {
        given()
                .header(header[0], header[1])
                .and()
                .body(existedUser)
                .when()
                .post(authorisation)
                .then()
                .statusCode(200);
    }

    @Test
    public void loginAsIncorrectEmailUserAndCheckStatusCodeAndMessageTest() {
        given()
                .header(header[0], header[1])
                .and()
                .body(incorrectEmailUser)
                .when()
                .post(authorisation)
                .then()
                .statusCode(401)
                .and()
                .assertThat().body("message", equalTo("email or password are incorrect"));
    }

    @Test
    public void loginAsIncorrectPasswordUserAndCheckStatusCodeAndMessageTest() {
        given()
                .header(header[0], header[1])
                .and()
                .body(incorrectPasswordUser)
                .when()
                .post(authorisation)
                .then()
                .statusCode(401)
                .and()
                .assertThat().body("message", equalTo("email or password are incorrect"));
    }
}
