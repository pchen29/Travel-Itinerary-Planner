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
import java.util.List;
import java.util.Scanner;

public class Flights {

    public static void getFlights(String country,String currency,String originPlace,String destinationPlace,String outboundDate,String inboundDate){
        String inbound="";
        if (inboundDate!=null){
            inbound="?inboundpartialdate="+inboundDate;
        }
        HttpResponse<JsonNode> response = null;
        try {
            response= Unirest.get("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsequotes/v1.0/"+country+"/"+currency+"/en-US/"+originPlace+"/"+destinationPlace+"/"+outboundDate+inbound)
                    .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
                    .header("x-rapidapi-key", ApiKey.getApiKeyFlights())
                    .asJson();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        System.out.println(response.getBody());
        //Map Json to objects
        Flight flights=null;
        ObjectMapper mapper= new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        try {
            flights=mapper.readValue(response.getBody().toString(), Flight.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        getFlight(flights);

    }

    public static void getFlight(Flight flights){
        List<Carrier> carriers=flights.getCarriers();
        List<Quote> quotes=flights.getQuotes();
        List<Currency> currencies=flights.getCurrencies();
        List<Place> places=flights.getPlaces();
        for (Quote quote:flights.getQuotes()){
            System.out.println(quote);
        }


    }


}
