package FlightObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Itinerary {

    private String inboundLegId;
    private String outboundLegId;
    private List<PricingOptions> pricingOptions;

    @JsonCreator
    public Itinerary(@JsonProperty("InboundLegId") String inboundLegId,
                     @JsonProperty("OutboundLegId") String outboundLegId,
                     @JsonProperty("PricingOptions") List<PricingOptions> pricingOptions){
        this.inboundLegId=inboundLegId;
        this.outboundLegId=outboundLegId;
        this.pricingOptions=pricingOptions;
    }

    @Override
    public String toString() {
        return "Itineraries{" +
                "inboundLegId='" + inboundLegId + '\'' +
                ", outboundLegId='" + outboundLegId + '\'' +
                ", pricingOptions=" + pricingOptions +
                '}';
    }

    public String getInboundLegId() {
        return inboundLegId;
    }

    public String getOutboundLegId() {
        return outboundLegId;
    }

    public List<PricingOptions> getPricingOptions() {
        return pricingOptions;
    }
}
