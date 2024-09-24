//import com.google.gson.Gson;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//import org.hamcrest.MatcherAssert;
//import org.junit.Before;
//import org.junit.Test;
//
//import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;
//
//
//public class TryingTest {
//
//    private final String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MjAzNmQyY2RjY2Q4YTAwM2RlMTBkYzgiLCJpYXQiOjE3MjY1NjU2ODQsImV4cCI6MTcyNzE3MDQ4NH0.oFWuOIrGgz8Wf4uE-dlPrlu2QCEPQuUK806Um7WQby0";
//    private final Card card = new Card("Интересное место 12we", "https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/photoSelenide.jpg");
//    private final Gson gson = new Gson();
//    private String json = gson.toJson(card);
//
//    @Before
//    public void setup() {
//        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
//    }
//
//
//    @Test()
//    public void getMyInfoStatusCode() {
//        given()
//                .auth().oauth2(token)
//                .get("/api/users/me")
//                .then().statusCode(200)
//                .and()
//                .body("data.name", equalTo("Denis Sangi"));
//    }
//
//    @Test
//    public void createNewPlaceAndCheckResponse() {
//        Response response =
//                given()
//                        .header("Content-Type", "application/json")
//                        .auth().oauth2(token)
//                        .and()
//                        .body(card)
//                        .when()
//                        .post("/api/cards");
//        response.then().assertThat().body("data._id", notNullValue())
//                .and()
//                .statusCode(201);
//    }
//
//    @Test
//    public void createNewPlaceAndSaveResponseAsAPOJO() {
//        SimpleExample simpleExample =
//                given()
//                        .header("Content-Type", "application/json")
//                        .auth().oauth2(token)
//                        .and()
//                        .body(card)
//                        .when()
//                        .post("/api/cards")
//                        .body().as(SimpleExample.class);
//        MatcherAssert.assertThat(simpleExample, notNullValue());
//        System.out.println(simpleExample.getId());
//        System.out.println(simpleExample.getName());
//    }
//
//    @Test
//    public void updateNewPlaceAndCheckResponse() {
//
//        Response response =
//                given()
//                        .header("Content-Type", "application/json")
//                        .auth().oauth2(token)
//                        .and()
//                        .body(card)
//                        .when()
//                        .patch("/api/cards");
////        response.then().assertThat().body("data.name", equalTo("2e3rwg3"))
////                .and()
////                .statusCode(200);
//        System.out.println(response.body().asString());
//    }
//
//}
