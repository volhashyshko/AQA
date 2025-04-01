package testRA;

import endpoints.EndPointsZAGS;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import utilsAPI.ZAGSAPISpecification;
import java.util.List;
import static endpoints.EndPointsZAGS.URI;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) //экземпляр тестового класса будет создан один раз для всех тестовых методов в этом классе, все тестовые методы будут использовать один и тот же экземпляр тестового класса
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //задает порядок выполнения тестовых методов в классе

public class TestZAGS {
    @Test
    @Order(1)
    @DisplayName("Получение списка заявок")
    public void getListOfApplicationTest() {
        ZAGSAPISpecification.installSpecification(ZAGSAPISpecification.requestSpec(URI), ZAGSAPISpecification.responseSpecOK200());

        String username = "user";
        String password = "senlatest";

        Response response = given() //метод, который инициализирует контекст запроса. Результат этой операции будет храниться в переменной response типа Response
                .auth().preemptive().basic(username, password) //заголовок с учетными данными будет добавлен в запрос до его отправки
                .when() //метод указывает на начало этапа выполнения запроса. Он служит разделителем между настройкой запроса и его выполнением
                .get(EndPointsZAGS.APP) //метод выполняет HTTP GET запрос к указанному URL
                .then() //метод указывает, что мы переходим к фазе проверки (или ассертов) результатов запроса. Он начинает цепочку методов, которые выполняются после получения ответа.
                .log().all()
                .statusCode(200)
                .extract() //метод указывает, что мы хотим извлечь ответ, чтобы использовать его дальше в коде
                .response(); //метод завершает извлечение и возвращает объект Response, который содержит всю информацию о полученном ответе, включая тело ответа, заголовки и код состояния.

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

        RequestForCreationApp app = new RequestForCreationApp("wedding", "Шишко", "Ольга", "Александровна","2323232323", "КН311111","Шишко","Павел", "Иванович", "1985-01-01", "КН322222", "мужской", "2025-03-31", "Шишко", "Одинец", "Ольга", "Александровна", "1986-03-02", "КН333333", null, null, null, null, null, "Gorod", null, null, "Gorod");
        ResponseCreationApp successApp = given()
                .auth().preemptive().basic(username, password)
                .body(app)
                .when()
                .post(EndPointsZAGS.USERS)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(ResponseCreationApp.class);

        assertNotNull(successApp, "Response should not be null"); // Проверка содержания ответа
    }
}
