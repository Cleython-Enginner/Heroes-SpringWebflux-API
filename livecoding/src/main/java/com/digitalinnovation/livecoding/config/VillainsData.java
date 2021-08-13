package com.digitalinnovation.livecoding.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import static com.digitalinnovation.livecoding.constants.HeroesConstant.ENDPOINT_DYNAMO;
import static com.digitalinnovation.livecoding.constants.HeroesConstant.REGION_DYNAMO;

public class VillainsData {
    public static void main(String[] args) throws Exception {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Villains_Api_Table");

        Item villain = new Item()
                .withPrimaryKey("id", "2")
                .withString("name", "Loki")
                .withString("universe", "dc comics")
                .withNumber("films", 2);

        Item villain2 = new Item()
                .withPrimaryKey("id", "3")
                .withString("name", "ZEMO")
                .withString("universe", "marvel")
                .withNumber("films", 2);

        Item villain3 = new Item()
                .withPrimaryKey("id", "4")
                .withString("name", "THANOS")
                .withString("universe", "marvel")
                .withNumber("films", 2);

        PutItemOutcome outcome1 = table.putItem(villain);
        PutItemOutcome outcome2 = table.putItem(villain2);
        PutItemOutcome outcome3 = table.putItem(villain2);

    }


}
