package com.company;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class PixelEncounter {
    public static void randomPlanet(String width, String height, int frame){
        HttpResponse<String> result = Unirest.get("https://app.pixelencounter.com/api/basic/planets?")
                .queryString("width",width)
                .queryString("height", height)
                .queryString("frame", frame)
                .asString();
        System.out.println(result.getBody());
    }
    public static void monster(){
        HttpResponse<String> result = Unirest.get("https://app.pixelencounter.com/api/basic/monsters/random")
                .asString();
        System.out.println(result.getBody());
    }
    public static void pageOfMonsters (int page, int startRange, int endRange){
        HttpResponse<String> result = Unirest.get("https://app.pixelencounter.com/api/basic/monsters")
                .queryString("page",page)
                .queryString("startRange", startRange)
                .queryString("endRange", endRange)
                .asString();
        System.out.println(result.getBody());
    }

    public static void randomDog (){
        /*HttpResponse<JsonNode> response = Unirest.post("https://random.dog/")//URL, endpoint
                .asJson();*/
        HttpResponse<String> result = Unirest.get("https://random.dog/")
                .asString();
        System.out.println(result.getBody());
        //System.out.println(response.getStatus());
        //System.out.println(response.getBody());
    }
    public static void comic(){
        HttpResponse<String> result = Unirest.get("https://xkcd.com/info.0.json")
                .asString();
        System.out.println(result.getBody());
    }
}
