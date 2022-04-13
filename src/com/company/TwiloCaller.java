package com.company;

import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import kong.unirest.HttpResponse;

public class TwiloCaller {


    public static void sendText(){
        HttpResponse<JsonNode> response = Unirest.post("https://api.twilio.com/2010-04-01/Accounts/ACe9914e96188878961c142c394597faf7/Messages.json")//URL, endpoint
                .basicAuth("ACe9914e96188878961c142c394597faf7","f8f8a10ac2dd8c265ef5b7ed607f5d81")//token
                .field("To", "15614799957")//what data to send to the API request
                .field("Body", "Hello God")//q data
                .field("From", "17622275314")
                .asJson();
        System.out.println(response.getStatus());
        System.out.println(response.getBody());
    }
}
