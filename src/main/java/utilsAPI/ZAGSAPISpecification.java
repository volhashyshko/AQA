package utilsAPI;

import endpoints.EndPointsZAGS;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ZAGSAPISpecification {
    public static RequestSpecification requestSpec(String URI){
        return new RequestSpecBuilder()
                .setBaseUri(EndPointsZAGS.URI)
                .setContentType(ContentType.JSON)
                .log(LogDetail.METHOD)
                .log(LogDetail.URI)
                .log(LogDetail.HEADERS)
                .log(LogDetail.BODY)
                .build();
    }
    public static ResponseSpecification responseSpecOK200(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
    public static void installSpecification(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request; //объект, который содержит настройки запроса
        RestAssured.responseSpecification = response; //объект, который описывает ожидаемые характеристики ответа
    }
}
