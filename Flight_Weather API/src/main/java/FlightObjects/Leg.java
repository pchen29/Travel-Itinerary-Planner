package FlightObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Leg {
    private List<Integer> segmentIds;
    private int duration;
    private String arrival;
    private List<Integer> carriers;
    private String directionality;
    private int originStation;
    private String departure;
    private List<FlightNumber> flightNumbers;
    private String journeyMode;
    private int destinationStation;
    private List<Integer> stops;
    private List<Integer>  operatingCarriers;
    private String id;

    @JsonCreator
    public Leg(@JsonProperty("SegmentIds") List<Integer> segmentIds,
               @JsonProperty("Duration")int duration,
               @JsonProperty("Arrival")String arrival,
               @JsonProperty("Carriers")List<Integer> carriers,
               @JsonProperty("Directionality")String directionality,
               @JsonProperty("OriginStation")int originStation,
               @JsonProperty("Departure")String departure,
               @JsonProperty("FlightNumbers")List<FlightNumber> flightNumbers,
               @JsonProperty("JourneyMode")String journeyMode,
               @JsonProperty("DestinationStation")int destinationStation,
               @JsonProperty("Stops")List<Integer> stops,
               @JsonProperty("OperatingCarriers")List<Integer> operatingCarriers,
               @JsonProperty("Id")String id){
        this.segmentIds=segmentIds;
        this.duration=duration;
        this.arrival=arrival;
        this.carriers=carriers;
        this.directionality=directionality;
        this.originStation=originStation;
        this.departure=departure;
        this.flightNumbers=flightNumbers;
        this.journeyMode=journeyMode;
        this.destinationStation=destinationStation;
        this.stops=stops;
        this.operatingCarriers=operatingCarriers;
        this.id=id;
    }

    @Override
    public String toString() {
        return "Leg{" +
                "segmentIds=" + segmentIds +
                ", duration=" + duration +
                ", arrival='" + arrival + '\'' +
                ", carriers=" + carriers +
                ", directionality='" + directionality + '\'' +
                ", originStation=" + originStation +
                ", departure='" + departure + '\'' +
                ", flightNumbers=" + flightNumbers +
                ", journeyMode='" + journeyMode + '\'' +
                ", destinationStation=" + destinationStation +
                ", stops=" + stops +
                ", operatingCarriers=" + operatingCarriers +
                ", id='" + id + '\'' +
                '}';
    }


    public List<Integer> getSegmentIds() {
        return segmentIds;
    }

    public int getDuration() {
        return duration;
    }

    public String getArrival() {
        return arrival;
    }

    public List<Integer> getCarriers() {
        return carriers;
    }

    public String getDirectionality() {
        return directionality;
    }

    public int getOriginStation() {
        return originStation;
    }

    public String getDeparture() {
        return departure;
    }

    public List<FlightNumber> getFlightNumbers() {
        return flightNumbers;
    }

    public String getJourneyMode() {
        return journeyMode;
    }

    public int getDestinationStation() {
        return destinationStation;
    }

    public List<Integer> getStops() {
        return stops;
    }

    public List<Integer> getOperatingCarriers() {
        return operatingCarriers;
    }

    public String getId() {
        return id;
    }
}
