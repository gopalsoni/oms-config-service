package com.hbi.oms.config.service.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.hbi.oms.config.service.GatewayResponse;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Handler for requests to Lambda function.
 */
public class OmsConfigHandler implements RequestHandler <Object, Object> {

    public Object handleRequest(final Object input, final Context context) {
        Map <String, String> headers = new HashMap <>();
        headers.put("Content-Type", "application/json");
        return new GatewayResponse(new JSONObject().put("Output", "Hello Gopal!").toString(), headers, 200);
    }
}
