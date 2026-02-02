package com.ranjit.harmony.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonUtil {

    public static ObjectMapper mapper = new ObjectMapper();

    // Generic method to convert any object to a JSON string
    public static <T> String toJson(T object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            // Handle or log the exception as needed
            e.printStackTrace();
            return null;
        }
    }

}
