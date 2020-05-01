import AttractionObjects.*;

import AttractionObjects.Data;
import HotelObjects.Hotel;
import LocationObjects.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.util.List;

public class TripAdvisor {

    public static void getAttractions(int location_id){
    HttpResponse<JsonNode> response = null;
    try
    {
        response=Unirest.get("https://tripadvisor1.p.rapidapi.com/attractions/list?lang=en_US&currency=USD&sort=recommended&lunit=km&limit=30&bookable_first=false&subcategory=36&location_id="+location_id)
                .header("x-rapidapi-host", "tripadvisor1.p.rapidapi.com")
                .header("x-rapidapi-key", ApiKey.getApiKeyFlights())
                .asJson();
    }
    catch(UnirestException e){
        e.printStackTrace();
    }
    Attraction attractions=null;
    ObjectMapper mapper=new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    try {
        attractions=mapper.readValue(response.getBody().toString(),Attraction.class);
    }catch (IOException e){
        e.printStackTrace();
    }
    getAttraction(attractions);

    }
    public static void getAttraction(Attraction attractions){
        System.out.println(attractions.getData().get(0).toString());

    }

    public static void  getLocations(String location){
        location=location.replaceAll(" ","%20");
        HttpResponse<JsonNode> response = null;
        try {
            response=Unirest.get("https://tripadvisor1.p.rapidapi.com/locations/search?location_id=1&limit=30&sort=relevance&offset=0&lang=en_US&currency=USD&units=km&query="+location)
                    .header("x-rapidapi-host", "tripadvisor1.p.rapidapi.com")
                    .header("x-rapidapi-key", ApiKey.getApiKeyFlights())
                    .asJson();
        }
        catch (UnirestException e){
            e.printStackTrace();
        }
        Location locations=null;
        ObjectMapper mapper=new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        try{
            locations=mapper.readValue(response.getBody().toString(),Location.class);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        getLocation(locations);
    }
    public static void getLocation(Location locations){
        for (LocationObjects.Data data:locations.getData()){
            if (data.getResult_type().equals("geos")){
                getAttractions(data.getResult_object().getLocation_id());
                getHotels(data.getResult_object().getLocation_id());
            }
        }
    }
    public static void getHotels(int location_id){
        HttpResponse<JsonNode> response =null;
        try{
            response=Unirest.get("https://tripadvisor1.p.rapidapi.com/hotels/get-details?adults=1&nights=2&currency=USD&lang=en_US&child_rm_ages=7%252C10&checkin=2020-06-15&location_id="+location_id)
                    .header("x-rapidapi-host", "tripadvisor1.p.rapidapi.com")
                    .header("x-rapidapi-key", ApiKey.getApiKeyFlights())
                .asJson();
        }catch (UnirestException e){
            e.printStackTrace();
        }
        Hotel hotels=null;
        ObjectMapper mapper=new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        try {
            hotels=mapper.readValue(response.getBody().toString(),Hotel.class);
        }catch (IOException e){
            e.printStackTrace();
        }
        getHotel(hotels);
        }
        public static void  getHotel(Hotel hotels){
            System.out.println(hotels.getData().get(0).toString());
    }


}
