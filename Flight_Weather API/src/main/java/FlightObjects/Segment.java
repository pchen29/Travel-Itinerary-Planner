package FlightObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Segment {
    private String directionality;
    private int originStation;
    private String departureDateTime;
    private String arrivalDateTime;
    private String journeyMode;
    private int destinationStation;
    private int operatingCarrier;
    private int flightNumber;
    private int duration;
    private int id;
    private int carrier;

    @JsonCreator
    public Segment(@JsonProperty("Directionality") String directionality,
                   @JsonProperty("OriginStation")int originStation,
                   @JsonProperty("DepartureDateTime")String departureDateTime,
                   @JsonProperty("ArrivalDateTime")String arrivalDateTime,
                   @JsonProperty("JourneyMode")String journeyMode,
                   @JsonProperty("DestinationStation")int destinationStation,
                   @JsonProperty("OperatingCarrier")int operatingCarrier,
                   @JsonProperty("FlightNumber")int flightNumber,
                   @JsonProperty("Duration")int duration,
                   @JsonProperty("Id")int id,
                   @JsonProperty("Carrier")int carrier) {
        this.directionality = directionality;
        this.originStation = originStation;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.journeyMode = journeyMode;
        this.destinationStation = destinationStation;
        this.operatingCarrier = operatingCarrier;
        this.flightNumber = flightNumber;
        this.duration = duration;
        this.id = id;
        this.carrier = carrier;
    }

    @Override
    public String toString() {
        return "Segment{" +
                "directionality='" + directionality + '\'' +
                ", originStation=" + originStation +
                ", departureDateTime='" + departureDateTime + '\'' +
                ", arrivalDateTime='" + arrivalDateTime + '\'' +
                ", journeyMode='" + journeyMode + '\'' +
                ", destinationStation=" + destinationStation +
                ", operatingCarrier=" + operatingCarrier +
                ", flightNumber=" + flightNumber +
                ", duration=" + duration +
                ", id=" + id +
                ", carrier=" + carrier +
                '}';
    }

    public String getDirectionality() {
        return directionality;
    }

    public int getOriginStation() {
        return originStation;
    }

    public String getDepartureDateTime() {
        return departureDateTime;
    }

    public String getArrivalDateTime() {
        return arrivalDateTime;
    }

    public String getJourneyMode() {
        return journeyMode;
    }

    public int getDestinationStation() {
        return destinationStation;
    }

    public int getOperatingCarrier() {
        return operatingCarrier;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public int getDuration() {
        return duration;
    }

    public int getId() {
        return id;
    }

    public int getCarrier() {
        return carrier;
    }
}
