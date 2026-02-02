package com.ranjit.harmony.client;

import com.ranjit.harmony.endpoints.ApiEndPoints;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static com.ranjit.harmony.endpoints.ApiEndPoints.base_path;
import static com.ranjit.harmony.endpoints.ApiEndPoints.endPoint;
import static io.restassured.RestAssured.given;

public class ApiClient {

    static {
        RestAssured.baseURI = base_path;
        requestSpec();
    }

    public static RequestSpecification requestSpec() {

        return new RequestSpecBuilder()
                .setBaseUri(base_path)
                .setBasePath(endPoint)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .log(LogDetail.ALL)
                .build();
    }

    public Response post(Object payload) {
        return given().spec(requestSpec())
                .log().all()
                .body(payload)
                .when()
                .post()
                .then()
                .log().all()
                .extract().response();
    }


    public Response post(String endpoint, Object payload) {
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/json");

        return given()
                .headers(header)
                //.header("Content-Type", "application/json")
                //.header("","")
                //.auth().preemptive().basic("","")
                .log().all()
                .body(payload)
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract().response();
    }

    public Response get(String endpoint, String id) {
        return given()
                .pathParam("id", id)
                .log().all()
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract().response();
    }

    public Response put(String endpoint, String id, Object payload) {
        return given()
                .pathParam("id", id)
                .header("Content-Type", "application/json")
                .log().all()
                .body(payload)
                .when()
                .put(endpoint)
                .then()
                .log().all()
                .extract().response();
    }

    public Response delete(String endpoint, String id) {
        return given()
                .pathParam("id", id)
                .log().all()
                .when()
                .delete(endpoint)
                .then()
                .log().all()
                .extract().response();
    }
}
