import AttractionObjects.Category;
import AttractionObjects.Data;
import FlightObjects.Quote;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.http.Status;

import java.util.ArrayList;
import java.util.List;

public class TravelInformationHandler implements Handler {


    @Override
    public void handle(Context context) throws Exception {
        context.parse(Parameters.class)
                .onError(error -> context.getResponse().status(Status.BAD_REQUEST).send("Fail to parse" + error))
                .blockingOp(this::callApis)
                .then(parameters -> context.getResponse().send("Planing Trip..."));

    }
    //Function executed when the server is called
    private void callApis(Parameters parameters) throws Exception {
        System.out.println("Planing Flights...");
        List<Quote> flight1=Flights.getFlights("UK","GBP",parameters.getOriginStation()+"-sky",parameters.getDestinationStation()+"-sky",parameters.getOutboundDate(),null);
        List<Quote> flight2=Flights.getFlights("UK","GBP",parameters.getDestinationStation()+"-sky",parameters.getOriginStation()+"-sky",parameters.getInboundDate(),null);
        List<Integer> locationIds=TripAdvisor.findLocations(parameters.getDestination());
        System.out.println(locationIds);
        List<List<List<Data>>> allLocationAttractions=new ArrayList<>();
        List<List<HotelObjects.Data>> allLocationHotels=new ArrayList<>();
        System.out.println("Flights Done!");
        System.out.println("Planing  Attractions and Hotels...");
        for (Integer locationId:locationIds){
            List<List<Data>> allAttractions=new ArrayList<>();
            allAttractions.add(TripAdvisor.getApiAttractions(locationId,parameters.getSubCategory1(),5));
            System.out.println("Done Category 1");
            allAttractions.add(TripAdvisor.getApiAttractions(locationId,parameters.getSubCategory2(),5));
            System.out.println("Done Category 2");
            allAttractions.add(TripAdvisor.getApiAttractions(locationId,parameters.getSubCategory3(),5));
            System.out.println("Done Category 3");
            allLocationAttractions.add(allAttractions);
            allLocationHotels.add(TripAdvisor.getApiHotels(locationId));
            System.out.println("Done Hotels");
        }


        List<List<String>> days=new ArrayList<>();
        for (int i=0; i<5;i++){
            days.add(new ArrayList<>());
        }
        for (int location=0; location<allLocationAttractions.size(); location++){
                for (int category = 0; category < allLocationAttractions.get(location).size(); category++) {
                    for (int attraction = 0; attraction < allLocationAttractions.get(location).get(category).size(); attraction++) {
                        Data attractionData=allLocationAttractions.get(location).get(category).get(attraction);
                        days.get(attraction).add( " Day Time: " + category + " Attraction: " + attractionData.getName() +
                                " Ranking: "+ attractionData.getRating() +" Description: "+attractionData.getDescription() + " Web Url "+ attractionData.getWebsite()+" TripAdvisor Url: "+attractionData.getWeb_url());
                    }
                }

        }

        List<String> allhotels=new ArrayList<>();
        for (List<HotelObjects.Data> hotels : allLocationHotels){
                allhotels.add("Hotel: " + hotels.get(0).getName() + " Class: " + hotels.get(0).getClass() + " Price: " + hotels.get(0).getPrice() + " Website: " + hotels.get(0).getWebsite() + " TriAdvisor Url: " + hotels.get(0).getTripAdvisor_web_url());
            }

        String flight1quote= "Origin: "+parameters.getOrigin()+" Airport: "+parameters.getOriginStation()+" Destination: "+parameters.getDestination()+" Airport: "+ parameters.getDestinationStation()+" Time: "+flight1.get(0).getOutboundLeg().getDepartureDateTime()+" Min Price: "+flight1.get(0).getMinPrice();
        String flight2quote= "Origin: "+parameters.getDestination()+" Airport: "+parameters.getDestinationStation()+" Destination: "+parameters.getOrigin()+" Airport: "+ parameters.getOriginStation()+" Time: "+flight2.get(0).getOutboundLeg().getDepartureDateTime()+" Min Price: "+flight2.get(0).getMinPrice();

        SendEmail.emailSender(parameters.getEmail(),flight1quote,flight2quote,allhotels,days);
    }
    //Javascript Json parameters
    public static class Parameters{
        private String email;
        private String origin;
        private String destination;
        private String originStation;
        private String destinationStation;
        private String outboundDate;
        private String inboundDate;
        private String subCategory1;
        private String subCategory2;
        private String subCategory3;
        @JsonCreator
        public Parameters(@JsonProperty("email") String email,
                          @JsonProperty("origin") String origin,
                          @JsonProperty("destination")String destination,
                          @JsonProperty("originStation") String originStation,
                          @JsonProperty("destinationStation") String destinationStation,
                          @JsonProperty("outboundDate")String outboundDate,
                          @JsonProperty("subCategory1")String subCategory1,
                          @JsonProperty("subCategory2")String subCategory2,
                          @JsonProperty("subCategory3")String subCategory3,
                          @JsonProperty("inboundDate")String inboundDate) {
            this.email=email;
            this.origin = origin;
            this.destination = destination;
            this.originStation=originStation;
            this.destinationStation=destinationStation;
            this.outboundDate = outboundDate;
            this.subCategory1=subCategory1;
            this.subCategory2=subCategory2;
            this.subCategory3=subCategory3;
            this.inboundDate = inboundDate;
            if (origin==null|| destination==null || outboundDate==null || inboundDate==null
                    || email==null || destinationStation==null || originStation==null){
                throw new NullPointerException("Missing values");
            }
        }

        public String getSubCategory1() {
            return subCategory1;
        }

        public String getSubCategory2() {
            return subCategory2;
        }

        public String getSubCategory3() {
            return subCategory3;
        }

        public String getEmail() {
            return email;
        }

        public String getOrigin() {
            return origin;
        }

        public String getDestination() {
            return destination;
        }

        public String getOriginStation() {
            return originStation;
        }

        public String getDestinationStation() {
            return destinationStation;
        }

        public String getOutboundDate() {
            return outboundDate;
        }

        public String getInboundDate() {
            return inboundDate;
        }
    }
}
