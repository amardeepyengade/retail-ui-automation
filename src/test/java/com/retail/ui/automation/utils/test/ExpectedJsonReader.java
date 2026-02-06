package com.retail.ui.automation.utils.test;

import java.io.InputStream;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExpectedJsonReader {

	private static JsonNode rootNode;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();

            InputStream is = ExpectedJsonReader.class
                    .getClassLoader()
                    .getResourceAsStream("src/test/resources/expectedResult.json");

            if (is == null) {
                throw new RuntimeException("expected.json not found in classpath");
            }

            rootNode = mapper.readTree(is);

        } catch (Exception e) {
            e.printStackTrace(); // IMPORTANT for visibility
            throw new RuntimeException("Failed to initialize ExpectedJsonReader", e);
        }
    }

    public static String getExpectedValue(String parentKey, String childKey) {
        JsonNode parentNode = rootNode.get(parentKey);

        if (parentNode == null) {
            throw new RuntimeException(
                "Parent key not found in JSON: " + parentKey
            );
        }

        JsonNode valueNode = parentNode.get(childKey);

        if (valueNode == null) {
            throw new RuntimeException(
                "Child key not found: " + childKey + " under " + parentKey
            );
        }

        return valueNode.asText();
    }
}

