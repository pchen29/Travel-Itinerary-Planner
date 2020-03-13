package FlightObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Query {
    private String locale;
    private String locationScheme;
    private int infants;
    private String inboundDate;
    private int originPlace;
    private String cabinClass;
    private String currency;
    private boolean groupPricing;
    private String country;
    private int adults;
    private int children;
    private String outboundDate;
    private int destinationPlace;

    @JsonCreator
    public Query(@JsonProperty("Locale") String locale,
                 @JsonProperty("LocationSchema")String locationScheme,
                 @JsonProperty("Infants")int infants,
                 @JsonProperty("InboundDate")String inboundDate,
                 @JsonProperty("OriginPlace")int originPlace,
                 @JsonProperty("CabinClass")String cabinClass,
                 @JsonProperty("Currency")String currency,
                 @JsonProperty("GroupPricing")boolean groupPricing,
                 @JsonProperty("Country")String country,
                 @JsonProperty("Adults")int adults,
                 @JsonProperty("Children")int children,
                 @JsonProperty("OutboundDate")String outboundDate,
                 @JsonProperty("DestinationPlace")int destinationPlace) {
        this.locale = locale;
        this.locationScheme = locationScheme;
        this.infants = infants;
        this.inboundDate = inboundDate;
        this.originPlace = originPlace;
        this.cabinClass = cabinClass;
        this.currency = currency;
        this.groupPricing = groupPricing;
        this.country = country;
        this.adults = adults;
        this.children = children;
        this.outboundDate = outboundDate;
        this.destinationPlace = destinationPlace;
    }

    @Override
    public String toString() {
        return "Query{" +
                "locale='" + locale + '\'' +
                ", locationScheme='" + locationScheme + '\'' +
                ", infants=" + infants +
                ", inboundDate='" + inboundDate + '\'' +
                ", originPlace=" + originPlace +
                ", cabinClass='" + cabinClass + '\'' +
                ", currency='" + currency + '\'' +
                ", groupPricing=" + groupPricing +
                ", country='" + country + '\'' +
                ", adults=" + adults +
                ", children=" + children +
                ", outboundDate='" + outboundDate + '\'' +
                ", destinationPlace=" + destinationPlace +
                '}';
    }

    public String getLocale() {
        return locale;
    }

    public String getLocationScheme() {
        return locationScheme;
    }

    public int getInfants() {
        return infants;
    }

    public String getInboundDate() {
        return inboundDate;
    }

    public int getOriginPlace() {
        return originPlace;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public String getCurrency() {
        return currency;
    }

    public boolean isGroupPricing() {
        return groupPricing;
    }

    public String getCountry() {
        return country;
    }

    public int getAdults() {
        return adults;
    }

    public int getChildren() {
        return children;
    }

    public String getOutboundDate() {
        return outboundDate;
    }

    public int getDestinationPlace() {
        return destinationPlace;
    }
}
