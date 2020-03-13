import FlightObjects.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Flights {

    public static void getFlights(){
        //Read Saved data from txt
        File file=new File("src/main/java/json1.txt");
        String data="";
        try {
            Scanner reader=new Scanner(file);
            while (reader.hasNextLine()){
                data+=reader.nextLine();
               // System.out.println(data);

            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       // System.out.println(data);

        //Create Season
//        HttpResponse<JsonNode> response=null;
//        try {
//             response= Unirest.post("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/pricing/v1.0")
//                    .header("X-RapidAPI-Host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
//                    .header("X-RapidAPI-Key", ApiKey.getApiKeyFlights())
//                    .header("Content-Type", "application/x-www-form-urlencoded")
//                    .field("inboundDate", "2020-05-10")
//                    .field("cabinClass", "economy")
//                    .field("children", 0)
//                    .field("infants", 0)
//                    .field("country", "UK")
//                    .field("currency", "USD")
//                    .field("locale", "en-US")
//                    .field("originPlace", "ATH-sky")
//                    .field("destinationPlace", "LHR-sky")
//                    .field("outboundDate", "2020-05-01")
//                    .field("adults", 1)
//                    .asJson();
//
//        } catch (UnirestException e) {
//            e.printStackTrace();
//        }
//        String location=response.getHeaders().getFirst("Location");
//
//        String sub=null;
//        for (int i=location.length()-1; i>0; i--){
//            if (location.charAt(i)=='/'){
//                sub=location.substring(i+1);
//                break;
//            }
//        }
//        Get from session
//        HttpResponse<JsonNode> response2=null;
//        try {
//            response2 = Unirest.get("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/pricing/uk2/v1.0/"+sub+"?pageIndex=0&pageSize=10")
//                    .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
//                    .header("x-rapidapi-key", ApiKey.getApiKeyFlights())
//                    .asJson();
//        } catch (UnirestException e) {
//            e.printStackTrace();
//        }

        //Map Json to objects
        Flight flights=null;
        ObjectMapper mapper= new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        try {
            //data variable for txt data
            //response2 variable for live data
            flights=mapper.readValue(data, Flight.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        getFlight(flights);

    }
    public static void getFlight(Flight flights){
        //TODO

        //Bad Example for a single flight
        Itinerary itinerary =flights.getItineraries().get(0);
        String inBoundId=itinerary.getInboundLegId();
        String outBoundId=itinerary.getOutboundLegId();
        List<PricingOptions> pricingOptions=itinerary.getPricingOptions();
        String url=pricingOptions.get(0).getDeeplinkUrl();
        double price=pricingOptions.get(0).getPrice();

        //Legs
        Leg inbound=null;
        Leg outbound=null;

        List<Leg> legs= flights.getLegs();
        for (Leg leg:legs){
            if (leg.getId().equals(inBoundId))
                inbound=leg;
            else if (leg.getId().equals(outBoundId))
                outbound=leg;
        }

//        inbound
        int duration=inbound.getDuration();
        String arrival=inbound.getArrival();
        String departure=inbound.getDeparture();

        int originStation=inbound.getOriginStation();
        int destinationStation=inbound.getDestinationStation();
        String origin="";
        String dest="";

        List<Place> places=flights.getPlaces();
        for (Place pl:places){
            if (pl.getId()==originStation)
                origin+=pl.getName();
            else if (pl.getId()==destinationStation)
                dest+=pl.getName();

        }
        System.out.println("Origin= "+origin+" Dest= " +dest+ " Depart= "+ departure+ " Arrival= "+arrival+ " Duration= "+duration);

        //outbound
        duration=outbound.getDuration();
        arrival=outbound.getArrival();
        departure=outbound.getDeparture();

        originStation=outbound.getOriginStation();
        destinationStation=outbound.getDestinationStation();
        origin="";
        dest="";

        places=flights.getPlaces();
        for (Place pl:places){
            if (pl.getId()==originStation)
                origin+=pl.getName();
            else if (pl.getId()==destinationStation)
                dest+=pl.getName();

        }
        System.out.println("Origin= "+origin+" Dest= " +dest+ " Depart= "+ departure+ " Arrival= "+arrival+ " Duration= "+duration + "\nPrice= "+price+" Url= "+url);
        System.out.println("Complete!");
        System.out.println("Complete!");

    }

}
