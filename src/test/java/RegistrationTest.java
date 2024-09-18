
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RegistrationTest {

    private final User randomUser = new User().getRandomUser();
    private final User existedUser = new User().getExistedUser();
    private final User userWithoutName = new User().getUserWithoutName();

    private final String register = "/auth/register";
    private final String[] header = {"Content-type", "application/json"};

    @Before
    public void setup() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/api";
    }

    @Test
    public void createNewUserAndCheckStatusCodeAndBody() {
                given()
                    .header(header[0], header[1])
                    .and()
                    .body(randomUser)
                    .when()
                    .post(register)
                    .then()
                    .assertThat().body("user.name",equalTo(randomUser.getName()))
                    .and()
                    .statusCode(200);

    }

    @Test
    public void createExistedUserAndCheckStatusCodeAndMessage() {
        given()
                .header(header[0], header[1])
                .and()
                .body(existedUser)
                .when()
                .post(register)
                .then()
                .assertThat().body("message", equalTo("User already exists"))
                .and()
                .statusCode(403);
    }

    @Test
    public void createUserWithoutNameAndCheckStatusCodeAndMessage() {
        given()
                .header(header[0], header[1])
                .and()
                .body(userWithoutName)
                .when()
                .post(register)
                .then()
                .assertThat().body("message", equalTo("Email, password and name are required fields"))
                .and()
                .statusCode(403);


    }
}
