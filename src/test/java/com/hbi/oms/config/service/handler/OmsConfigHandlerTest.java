package com.hbi.oms.config.service.handler;

import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;
import com.hbi.oms.config.service.GatewayResponse;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for {@link OmsConfigHandler}. Modify the tests in order to support your use case as you build your project.
 */
@DisplayName("Tests for OmsConfigHandler")
public class OmsConfigHandlerTest {

    private static final String EXPECTED_CONTENT_TYPE = "application/json";
    private static final String EXPECTED_RESPONSE_VALUE = "Hello Gopal!";
    private static final int EXPECTED_STATUS_CODE_SUCCESS = 200;

    // A mock class for com.amazonaws.services.lambda.runtime.Context
    private final MockLambdaContext mockLambdaContext = new MockLambdaContext();
    private final Object input = new Object();

    /**
     * Initializing variables before we run the tests.
     * Use @BeforeAll for initializing static variables at the start of the test class execution.
     * Use @BeforeEach for initializing variables before each test is run.
     */
    @BeforeAll
    static void setup() {
        // Use as needed.
    }

    /**
     * De-initializing variables after we run the tests.
     * Use @AfterAll for de-initializing static variables at the end of the test class execution.
     * Use @AfterEach for de-initializing variables at the end of each test.
     */
    @AfterAll
    static void tearDown() {
        // Use as needed.
    }

    /**
     * Basic test to verify the result obtained when calling {@link OmsConfigHandler} successfully.
     */
    @Test
    @DisplayName("Basic test for request handler")
    void testHandleRequest() {
        GatewayResponse response = (GatewayResponse) new OmsConfigHandler().handleRequest(input, mockLambdaContext);

        // Verify the response obtained matches the values we expect.
        JSONObject jsonObjectFromResponse = new JSONObject(response.getBody());
        assertEquals(EXPECTED_RESPONSE_VALUE, jsonObjectFromResponse.get("Output"));
        assertEquals(EXPECTED_CONTENT_TYPE, response.getHeaders().get("Content-Type"));
        assertEquals(EXPECTED_STATUS_CODE_SUCCESS, response.getStatusCode());
    }
}
