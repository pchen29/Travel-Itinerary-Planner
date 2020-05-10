package FlightObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OutboundLeg {
    private List<Integer> carrierIds;
    private String departureDateTime;
    private int originId;
    private int destinationId;

    @JsonCreator
    public OutboundLeg(@JsonProperty("CarrierIds") List<Integer> carrierIds,
                      @JsonProperty("DepartureDate")String departureDateTime,
                      @JsonProperty("OriginId")int originId,
                      @JsonProperty("DestinationId")int destinationId) {
        this.carrierIds = carrierIds;
        this.departureDateTime = departureDateTime;
        this.originId = originId;
        this.destinationId = destinationId;
    }

    @Override
    public String toString() {
        return "InboundLeg{" +
                "carrierIds=" + carrierIds +
                ", departureDateTime='" + departureDateTime + '\'' +
                ", originId=" + originId +
                ", destinationId=" + destinationId +
                '}';
    }

    public List<Integer> getCarrierIds() {
        return carrierIds;
    }

    public String getDepartureDateTime() {
        return departureDateTime;
    }

    public int getOriginId() {
        return originId;
    }

    public int getDestinationId() {
        return destinationId;
    }
}
