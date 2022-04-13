package com.company;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.util.HashMap;

public class SpotifyCaller {
    //Changes


    private static String token = "BQCiUTyw5k93naroC0dNCk3bOro-O7hjsFQWe2dTmGIyNK1wq8ox6OGu4F6sU3F7v6Gze48NqPWrBOpvqVWT8Jqxw1WI5A9sZfW9aqfXzt-DGAW7ExG_kYGCs2AYDQ8e8f4x83cS36jgg6GkyMaBD0TYnNVrclm2c8Q";
    public static void findArtistID(String artist){
        HttpResponse<String> result = Unirest.get("https://api.spotify.com/v1/search")
                .header("Authorization","bearer"+token)
                .queryString("q","Weezer")
                .queryString("type", "artist")
                .asString();
        System.out.println();
    }
    public static void getSeveralBrowseCategory(String country, String locale, String limit, String offset){
        HttpResponse<String> result = Unirest.get("https://api.spotify.com/v1/browse/categories")
                .header("Authorization","bearer"+token)
                .queryString("country",country)
                .queryString("locale", locale)
                .queryString("limit", limit)
                .queryString("offset", offset)
                .asString();
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
    }
    public static void sendText(String id){
        HttpResponse<JsonNode> response = Unirest.post("https://api.spotify.com/v1/me/shows")//URL, endpoint
                .basicAuth("Authorization",token)
                .field("ids", "id")//what data to send to the API request
                .asJson();
        System.out.println(response.getStatus());
        System.out.println(response.getBody());
    }
    public static void getRecentlyPlayedTracks(String limit, String after){
        HttpResponse<String> result = Unirest.get("https://api.spotify.com/v1/me/player/recently-played")
                .header("Authorization","bearer"+token)
                .queryString("limit",limit)
                .queryString("after", after)
                .asString();
    }
    public static void getAvaliableMarkets(){
        HttpResponse<String> result = Unirest.get("https://api.spotify.com/v1/markets")
                .header("Authorization","bearer"+token)
                .asString();
    }
    public static void getNewReleases(String country, String limit,String offset){
        HttpResponse<String> result = Unirest.get("https://api.spotify.com/v1/browse/new-releases")
                .header("Authorization","bearer"+token)
                .queryString("country",country)
                .queryString("limit",limit)
                .queryString("offset", offset)
                .asString();
    }
}
