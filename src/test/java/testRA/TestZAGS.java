package testRA;

import com.fasterxml.jackson.databind.ObjectMapper;
import endpoints.EndPointsZAGS;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import utilsAPI.ZAGSAPISpecification;
import java.io.File;
import java.io.IOException;
import java.util.List;
import static endpoints.EndPointsZAGS.URI;
import static io.restassured.RestAssured.given;
import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestZAGS {
    @Test
    @Order(1)
    @DisplayName("Получение списка заявок")
    public void getListOfApplicationTest() {
        ZAGSAPISpecification.installSpecification(ZAGSAPISpecification.requestSpec(URI), ZAGSAPISpecification.responseSpecOK200());

        String username = "user";
        String password = "senlatest";

        Response response = given()
                .auth().preemptive().basic(username, password)
                .when()
                .get(EndPointsZAGS.APP)
                .then()
                .log().all()
                .extract()
                .response();

        List<UserBody.UserData> applications = response.jsonPath().getList("data", UserBody.UserData.class);
        assertNotNull(applications, "Applications should not be null");
        assertFalse(applications.isEmpty(), "Applications list should not be empty");

    }
    @Test
    @Order(2)
    @DisplayName("Создание заявки")
    public void createApplicationTest() throws IOException {
        ZAGSAPISpecification.installSpecification(ZAGSAPISpecification.requestSpec(URI), ZAGSAPISpecification.responseSpecOK200());

        String username = "user";
        String password = "senlatest";

        ObjectMapper objectMapper = new ObjectMapper();
        RequestForCreationApp app = objectMapper.readValue(new File("src/test/resources/testData.json"), RequestForCreationApp.class);
        ResponseCreationApp successApp = given()
                .auth().preemptive().basic(username, password)
                .body(app)
                .when()
                .post(EndPointsZAGS.USERS)
                .then()
                .log().all()
                .extract()
                .as(ResponseCreationApp.class);

        assert successApp != null : "Response is null!";

        Integer applicationid = successApp.data().applicationid();
        UserBody userBody = given()
                .auth().preemptive().basic(username, password)
                .when()
                .get(EndPointsZAGS.GETID + "/" + applicationid)
                .then()
                .log().all()
                .extract()
                .as(UserBody.class);

        Assertions.assertNotNull(userBody, "Response is null!");

        String actualkindofapplication = userBody.data().kindofapplication();
        String expectedkindofapplication = "Получение свидетельства о браке";
        assertEquals(expectedkindofapplication, actualkindofapplication, "Actual name is '" + actualkindofapplication + "', Excpected - '" + expectedkindofapplication + "'.");
    }
}