package com.company;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.util.HashMap;

public class SpotifyCaller {
    //Changes


    private static String token = "BQBDPbkhFCq8OKzGkbvpEPdfJWlCX_DMsr2gR6kjukR_iID87JeL4HhVvIqn8_mzOuzbMGnB7G0vCFeBzz6Mao18Xe9mEZZemZgqNsr3E56V5OFUBU4iMw8soHkGpKDiMqWikFy72SGHB4ppchUXu-lPnwE42e0kgWY";
    public static void findArtistID(String artist){
        HttpResponse<String> result = Unirest.get("https://api.spotify.com/v1/search")
                .header("Authorization","bearer"+token)
                .queryString("q","Weezer")
                .queryString("type", "artist")
                .asString();
    }
    public static void getUserProfile(String id){
        HttpResponse<String> result = Unirest.get("https://api.spotify.com/v1/users/{user_id}")
                .header("Authorization","Bearer "+token)
                .queryString("user_id",id)
                .asString();
    }
    public static void getArtistRelatedArtist(String id){
        HttpResponse<String> result = Unirest.get("https://api.spotify.com/v1/artists/{id}/related-artists")
                .header("Authorization","Bearer "+token)
                .queryString("id",id)
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
    public static void getAlbumTracks(String id, String market, String limit,String offset){
        HttpResponse<String> result = Unirest.get("https://api.spotify.com/v1/albums/{id}/tracks")
                .header("Authorization","bearer"+token)
                .queryString("id",id)
                .queryString("market", market)
                .queryString("limit",limit)
                .queryString("offset", offset)
                .asString();
    }
}
