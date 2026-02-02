package com.ranjit.harmony.steps;

import com.ranjit.harmony.client.ApiClient;
import io.restassured.response.Response;

public class CommonSteps extends ApiClient {

    public Response createPost(Object payload) {
        return post(payload);
    }
}
