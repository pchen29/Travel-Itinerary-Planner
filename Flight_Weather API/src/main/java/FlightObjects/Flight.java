package FlightObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Flight {
    private List<Carrier> carriers;
    private List<Quote> quotes;
    private List<Currency> currencies;
    private List<Place> places;
@JsonCreator
    public Flight(@JsonProperty("Carriers") List<Carrier> carriers,
                  @JsonProperty("Quotes")List<Quote> quotes,
                  @JsonProperty("Currencies")List<Currency> currencies,
                  @JsonProperty("Places")List<Place> places) {
        this.carriers = carriers;
        this.quotes = quotes;
        this.currencies = currencies;
        this.places = places;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "carriers=" + carriers +
                ", quotes=" + quotes +
                ", currencies=" + currencies +
                ", places=" + places +
                '}';
    }

    public List<Carrier> getCarriers() {
        return carriers;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public List<Place> getPlaces() {
        return places;
    }
}
