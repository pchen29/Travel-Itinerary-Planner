import ratpack.handling.Context;
import ratpack.server.RatpackServer;

import java.net.UnknownHostException;

public class Main {
    public static void main (String args[]) throws Exception {
        //Start Server
        RatpackServer.start(serverDefinition ->
                serverDefinition.handlers(chain->
                        chain.post("travel/information",new TravelInformationHandler())));
        //Weather.doHttpGet();
        //Flights.getFlights("UK","GBP","LHR-sky","MAN-sky","2020-07-01",null);
        //Flights.getFlights("UK","GBP","MAN-sky","LHR-sky","2020-07-11",null);
        //TripAdvisor.getLocations("London UK");
        //MongoDB.startMongoDB();

    }

}