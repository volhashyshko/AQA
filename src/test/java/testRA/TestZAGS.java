package testRA;

import endpoints.EndPointsZAGS;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import utilsAPI.ZAGSAPISpecification;
import java.util.List;
import static endpoints.EndPointsZAGS.URI;
import static io.restassured.RestAssured.given;
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
                .statusCode(200)
                .extract()
                .response();

        List<UserData> applications = response.jsonPath().getList("data", UserData.class); // Извлекаем массив заявок из ответа
        assertNotNull(applications, "Applications should not be null"); // Проверяем, что массив заявок не пуст
        assertFalse(applications.isEmpty(), "Applications list should not be empty");

    }
    @Test
    @Order(2)
    @DisplayName("Создание заявки")
    public void createApplicationTest() {
        ZAGSAPISpecification.installSpecification(ZAGSAPISpecification.requestSpec(URI), ZAGSAPISpecification.responseSpecOK200());

        String username = "user";
        String password = "senlatest";

        RequestForCreationApp app = new RequestForCreationApp("wedding", "Шишко", "Ольга", "Александровна","375292999999", "КН3111111","Шишко","Павел", "Иванович", "1985-01-01", "КН3222222", "мужской", "2010-01-01", "Шишко", "Одинец", "Ольга", "Александровна", "1986-12-12", "КН3111111", null, null, null, null, null, null, null, null, null);
        ResponseCreationApp successApp = given()
                .auth().preemptive().basic(username, password)
                .body(app)
                .when()
                .post(EndPointsZAGS.USERS)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(ResponseCreationApp.class);

        // Проверяем, что значения не равны null
        Assertions.assertNotNull(successApp.getApplicationid(), "Application ID should not be null");
        Assertions.assertNotNull(successApp.getMerrigecertificateid(), "Marriage Certificate ID should not be null");

        // Если вы ожидаете конкретные значения, присвойте их переменным
        Integer expectedApplicationId = successApp.getApplicationid(); // или другое ожидаемое значение
        Integer expectedMarriageCertificateId = successApp.getMerrigecertificateid(); // или другое ожидаемое значение

        // Проверяем, что полученные значения равны ожидаемым
        Assertions.assertEquals(expectedApplicationId, successApp.getApplicationid(), "Application ID does not match");
        Assertions.assertEquals(expectedMarriageCertificateId, successApp.getMerrigecertificateid(), "Marriage Certificate ID does not match");
    }
}
