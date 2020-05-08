import FlightObjects.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Flights {
//Retrieve data using the Skyscanner Api
    public static List<Quote> getFlights(String country,String currency,String originPlace,String destinationPlace,String outboundDate,String inboundDate){
        String inbound="";
        if (inboundDate!=null){
            inbound="?inboundpartialdate="+inboundDate;
        }
        //Get Response from API
        HttpResponse<JsonNode> response = null;
        try {
            response= Unirest.get("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsequotes/v1.0/"+country+"/"+currency+"/en-US/"+originPlace+"/"+destinationPlace+"/"+outboundDate+inbound)
                    .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
                    .header("x-rapidapi-key", ApiKey.getApiKeyFlights())
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        //Map Json to objects
        Flight flights=null;
        ObjectMapper mapper= new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        try {
            flights=mapper.readValue(response.getBody().toString(), Flight.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return getFlight(flights);

    }
//Get all available quotes from flights
    public static List<Quote> getFlight(Flight flights){
        List<Quote> flightQuotes=new ArrayList<>();
        List<Carrier> carriers=flights.getCarriers();
        List<Quote> quotes=flights.getQuotes();
        List<Currency> currencies=flights.getCurrencies();
        List<Place> places=flights.getPlaces();
        for (Quote quote:flights.getQuotes()){
            flightQuotes.add(quote);
        }
        return flightQuotes;
    }


}
