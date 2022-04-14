package com.company;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.util.HashMap;

public class SpotifyCaller {
    //Changes


    private static String token = "BQBnPtGmQaEQdJqzDfRM78acM0iMnSyw0i6FCpSPqkA_k9Xz4IYqJHtaRlDz_z5Tqn1JRMLfXuB3Y05yqOencXuuPmLm6-4j7O1qc0dUz_BxhtdULVoywKlcxNi2wjwuh0zDSggGK_gFt06lbyNT8Sr0WHlnv7V9RrE";
    public static void findArtistID(String artist){
        HttpResponse<String> result = Unirest.get("https://api.spotify.com/v1/search")
                .header("Authorization","Bearer "+token)
                .queryString("q","Weezer")
                .queryString("type", "artist")
                .asString();
        System.out.println(result.getBody());
    }
    public static void getSeveralBrowseCategory(String country, String locale, String limit, String offset){
        HttpResponse<String> result = Unirest.get("https://api.spotify.com/v1/browse/categories")
                .header("Authorization","Bearer "+token)
                .queryString("country",country)
                .queryString("locale", locale)
                .queryString("limit", limit)
                .queryString("offset", offset)
                .asString();
        System.out.println(result.getBody());
    }
    public static void getFeaturedPlaylists (String country, String locale, String timestamp, String limit, String offset){
        HttpResponse<String> result = Unirest.get("https://api.spotify.com/v1/browse/featured-playlists")
                .header("Authorization","Bearer "+token)
                .queryString("country", country)
                .queryString("locale",locale)
                .queryString("timestamp",timestamp)
                .queryString("limit",limit)
                .queryString("offset",offset)
                .asString();
        System.out.println(result.getBody());
    }
    public static void sendText(String id){
        HttpResponse<JsonNode> response = Unirest.post("https://api.spotify.com/v1/me/shows")//URL, endpoint
                .basicAuth("Authorization",token)
                .field("ids", "id")//what data to send to the API request
                .asJson();
        System.out.println(response.getStatus());
        System.out.println(response.getBody());
    }
    public static void getAvaliableMarkets(){
        HttpResponse<String> result = Unirest.get("https://api.spotify.com/v1/markets")
                .header("Authorization","Bearer "+token)
                .asString();
        System.out.println(result.getBody());
    }
    public static void getNewReleases(String country, String limit,String offset){
        HttpResponse<String> result = Unirest.get("https://api.spotify.com/v1/browse/new-releases")
                .header("Authorization","Bearer "+token)
                .queryString("country",country)
                .queryString("limit",limit)
                .queryString("offset", offset)
                .asString();
        System.out.println(result.getBody());
    }
    public static void getCurrentUserProfile(){
        HttpResponse<String> result = Unirest.get("https://api.spotify.com/v1/me")
                .header("Authorization","Bearer "+token)
                .asString();
        System.out.println(result.getBody());
    }

}
