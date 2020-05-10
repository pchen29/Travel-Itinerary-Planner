package FlightObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Quote {
    private int quoteId;
    private String quoteDateTime;
    private int MinPrice;
    private OutboundLeg outboundLeg;
    private InboundLeg inboundLeg;

    private boolean direct;
@JsonCreator
    public Quote(@JsonProperty("QuoteId") int quoteId,
                 @JsonProperty("QuoteDateTime")String quoteDateTime,
                 @JsonProperty("MinPrice")int minPrice,
                 @JsonProperty("OutboundLeg")OutboundLeg outboundLeg,
                 @JsonProperty("InboundLeg")InboundLeg inboundLeg,
                 @JsonProperty("Direct")boolean direct) {
        this.quoteId = quoteId;
        this.quoteDateTime = quoteDateTime;
        MinPrice = minPrice;
        this.outboundLeg = outboundLeg;
        this.inboundLeg = inboundLeg;
        this.direct = direct;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "quoteId=" + quoteId +
                ", quoteDateTime='" + quoteDateTime + '\'' +
                ", MinPrice=" + MinPrice +
                ", outboundLeg=" + outboundLeg +
                ", inboundLeg=" + inboundLeg +
                ", direct=" + direct +
                '}';
    }

    public int getQuoteId() {
        return quoteId;
    }

    public String getQuoteDateTime() {
        return quoteDateTime;
    }

    public int getMinPrice() {
        return MinPrice;
    }

    public OutboundLeg getOutboundLeg() {
        return outboundLeg;
    }

    public InboundLeg getInboundLeg() {
        return inboundLeg;
    }

    public boolean isDirect() {
        return direct;
    }
}
