import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import ratpack.handling.Context;
import ratpack.handling.Handler;
import ratpack.http.Status;

public class TravelInformationHandler implements Handler {


    @Override
    public void handle(Context context) throws Exception {
        context.parse(Parameters.class)
                .onError(error -> context.getResponse().status(Status.BAD_REQUEST).send("Fail to parse"+error))
                .blockingOp(this::callApis)
                .then(parameters->context.getResponse().send("Planing Trip..."));

    }
    private void callApis(Parameters parameters){
        Weather.doHttpGet();
        //Flights.getFlights("UK","GBP","LHR-sky","MAN-sky","2020-07-01",null);
        //Flights.getFlights("UK","GBP","MAN-sky","LHR-sky","2020-07-11",null);
        //TripAdvisor.getLocations("London UK");
    }
    public static class Parameters{
        private String origin;
        private String destination;
        private String outboundDate;
        private String inboundDate;
        @JsonCreator
        public Parameters(@JsonProperty("origin") String origin,
                          @JsonProperty("destination")String destination,
                          @JsonProperty("outboundDate")String outboundDate,
                          @JsonProperty("inboundDate")String inboundDate) {
            this.origin = origin;
            this.destination = destination;
            this.outboundDate = outboundDate;
            this.inboundDate = inboundDate;
            if (origin==null|| destination==null || outboundDate==null || inboundDate==null){
                throw new NullPointerException("Missing values");
            }
        }

        public String getOrigin() {
            return origin;
        }

        public String getDestination() {
            return destination;
        }

        public String getOutboundDate() {
            return outboundDate;
        }

        public String getInboundDate() {
            return inboundDate;
        }
    }
}
