package FlightObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightNumber {
    private int carrierId;
    private int flightNumber;

    @JsonCreator
    public FlightNumber(@JsonProperty("CarrierId") int carrierId,@JsonProperty("FlightNumber") int flightNumber){
        this.carrierId=carrierId;
        this.flightNumber=flightNumber;
    }

    @Override
    public String toString() {
        return "FlightNumber{" +
                "carrierId=" + carrierId +
                ", flightNumber=" + flightNumber +
                '}';
    }

    public int getCarrierId() {
        return carrierId;
    }

    public int getFlightNumber() {
        return flightNumber;
    }
}
