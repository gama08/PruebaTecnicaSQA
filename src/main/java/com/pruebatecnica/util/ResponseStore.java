package com.pruebatecnica.util;

import io.restassured.response.Response;

public class ResponseStore {
    private static Response lastResponse;

    public static void saveLastResponse(Response response) {
        lastResponse = response;
    }

    public static Response getLastResponse() {
        return lastResponse;
    }
}
