import AttractionObjects.*;

import HotelObjects.Data;
import HotelObjects.Hotel;
import LocationObjects.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TripAdvisor {
    //TripAdvisor Location API
    public static List<Integer> findLocations(String location) {
        location = location.replaceAll(" ", "%20");
        //Get response from API
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get("https://tripadvisor1.p.rapidapi.com/locations/search?location_id=1&limit=30&sort=relevance&offset=0&lang=en_US&currency=USD&units=km&query=" + location)
                    .header("x-rapidapi-host", "tripadvisor1.p.rapidapi.com")
                    .header("x-rapidapi-key", ApiKey.getApiKeyFlights())
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        Location locations = null;
        //Map Json to Location objects
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            locations = mapper.readValue(response.getBody().toString(), Location.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return findCityLocation(locations);
    }

    public static List<Integer> findCityLocation(Location locations) {
        List<Integer> locationIds=new ArrayList<>();
        for (LocationObjects.Data data : locations.getData()) {
            //Check if type is a City
            if (data.getResult_type().equals("geos") && data.getResult_object().getSubcategory().get(0).getKey().equals("city")) {
                locationIds.add(data.getResult_object().getLocation_id());
            }
        }
        return locationIds;
    }

    //TripAdvisor Attraction API
    public static List<AttractionObjects.Data> getApiAttractions(int location_id, String subCategory, int numberOfDays) {
        if (subCategory==null){
            subCategory="0";
        }
        //Get response from API
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.get("https://tripadvisor1.p.rapidapi.com/attractions/list?lang=en_US&currency=USD&sort=recommended&lunit=km&limit=30&bookable_first=false&subcategory="+subCategory+"&location_id=" + location_id)
                    .header("x-rapidapi-host", "tripadvisor1.p.rapidapi.com")
                    .header("x-rapidapi-key", ApiKey.getApiKeyFlights())
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        Attraction attractions = null;
        //Map Json to Attraction objects
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            attractions = mapper.readValue(response.getBody().toString(), Attraction.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getAttractions(attractions,numberOfDays);
    }

    public static List<AttractionObjects.Data> getAttractions(Attraction attractions, int numberOfDays) {
        List<AttractionObjects.Data> attractionList=new ArrayList<>();
        for (int i=0; i<numberOfDays; i++){
            attractionList.add(null);
           for (AttractionObjects.Data attraction:attractions.getData()){
               if (attraction.getName()!=null){
                    if (attractionList.get(i)==null && !attractionList.contains(attraction)){
                        attractionList.set(i,attraction);
                    }
                    else if (attractionList.get(i)!=null && !attractionList.contains(attraction)
                            && attractionList.get(i).getRaw_ranking() < attraction.getRaw_ranking()){

                        attractionList.set(i,attraction);

                    }
               }
           }
        }
        return attractionList;
    }

    //TripAdvisor Hotel API
    public static List<Data> getApiHotels(int location_id) {
        HttpResponse<JsonNode> response = null;
        //Get response from API
        try {
            response = Unirest.get("https://tripadvisor1.p.rapidapi.com/hotels/get-details?adults=1&nights=2&currency=USD&lang=en_US&child_rm_ages=7%252C10&checkin=2020-06-15&location_id=" + location_id)
                    .header("x-rapidapi-host", "tripadvisor1.p.rapidapi.com")
                    .header("x-rapidapi-key", ApiKey.getApiKeyFlights())
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        Hotel hotels = null;
        //Map Json to Hotel objects
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            hotels = mapper.readValue(response.getBody().toString(), Hotel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getHotels(hotels);
    }

    public static List<Data> getHotels(Hotel hotels) {
        List<Data> hotelList=new ArrayList<>();
        Data fiveClass =null;
        Data fourClass = null;
        Data threeClass = null;
        List<Data> allHotels=hotels.getData();
        for (Data hotel : allHotels) {
            if (hotel.getHotel_class() == 5.0) {
                if (fiveClass == null) {
                    fiveClass = hotel;
                } else if (fiveClass.getRaw_ranking() < hotel.getRaw_ranking()) {
                    fiveClass = hotel;
                }
            }
            if (hotel.getHotel_class() == 4.0) {
                if (fourClass == null) {
                    fourClass = hotel;
                } else if (fourClass.getRaw_ranking() < hotel.getRaw_ranking()) {
                    fourClass = hotel;
                }
            }
            if (hotel.getHotel_class() == 3.0) {
                if (threeClass == null) {
                    threeClass = hotel;
                } else if (threeClass.getRaw_ranking() < hotel.getRaw_ranking()) {
                    threeClass = hotel;
                }
            }
        }
        hotelList.add(fiveClass);
        hotelList.add(fourClass);
        hotelList.add(threeClass);
        return hotelList;
    }
}
