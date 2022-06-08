package com.media.focus.handler;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.media.focus.model.Customer;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class CustomerCreateHandler implements RequestStreamHandler {

    private static final String DYNAMODB_TABLE_NAME = System.getenv("TABLE_NAME");

    public void handleRequest(
            InputStream inputStream,
            OutputStream outputStream,
            Context context)
            throws IOException {

        JSONParser parser = new JSONParser();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        JSONObject responseJson = new JSONObject();

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
        DynamoDB dynamoDb = new DynamoDB(client);

        try {
            JSONObject event = (JSONObject) parser.parse(reader);

            if (event.get("body") != null) {
                Customer customer = new Customer((String) event.get("body"));

                dynamoDb.getTable(DYNAMODB_TABLE_NAME)
                        .putItem(new PutItemSpec().withItem(new Item()
                                .withString("internationalPhoneNumber",
                                        customer.getInternationalPhoneNumber())
                                .withString("name", customer.getName())
                                .withString("email", customer.getEmail())
                                .withBoolean("isAgree", customer.isAgree())
                                ));
            }

            JSONObject responseBody = new JSONObject();
            responseBody.put("message", "New item created");

            JSONObject headerJson = new JSONObject();
            headerJson.put("x-custom-header", "my custom header value");

            responseJson.put("statusCode", 200);
            responseJson.put("headers", headerJson);
            responseJson.put("body", responseBody.toString());

        } catch (ParseException pex) {
            responseJson.put("statusCode", 400);
            responseJson.put("exception", pex);
        }

        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(responseJson.toString());
        writer.close();
    }
}