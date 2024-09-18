
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.response.Response;

public class UserTest {

    private final User randomUser = new User().getRandomUser();
    private final User existedUser = new User().getExistedUser();

    @Before
    public void setup() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/api";
    }

    @Test
    public void createNewUserAndCheckStatusCodeAndBody() {
        Response response =
                given()
                    .header("Content-type", "application/json")
                    .and()
                    .body(randomUser)
                    .when()
                    .post("/auth/register");
        response.then().assertThat().body("user.name",equalTo(randomUser.getName()))
                .and()
                .statusCode(200);

    }

}
