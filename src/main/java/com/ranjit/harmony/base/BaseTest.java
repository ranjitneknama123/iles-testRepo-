package com.ranjit.harmony.base;

import com.ranjit.harmony.client.ApiClient;
import com.ranjit.harmony.endpoints.ApiEndPoints;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import static com.ranjit.harmony.endpoints.ApiEndPoints.base_path;

public class BaseTest {
    public static ApiClient apiClient;


    /*@BeforeClass
    public void setup() {
        apiClient = ApiClient.getInstance();
        RestAssured.baseURI = base_path;
    }*/
}
