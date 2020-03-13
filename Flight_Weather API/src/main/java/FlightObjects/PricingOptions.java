package FlightObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PricingOptions {
    private String deeplinkUrl;
    private double price;
    private List<Integer> agents;
    private int quoteAgeInMinutes;

    @JsonCreator
    public PricingOptions(@JsonProperty("DeeplinkUrl") String deeplinkUrl,
                          @JsonProperty("Price")double price,
                          @JsonProperty("Agents")List<Integer> agents,
                          @JsonProperty("QuoteAgeInMinutes")int quoteAgeInMinutes){
        this.deeplinkUrl=deeplinkUrl;
        this.price=price;
        this.agents=agents;
        this.quoteAgeInMinutes=quoteAgeInMinutes;

    }

    @Override
    public String toString() {
        return "PricingOptions{" +
                "deeplinkUrl='" + deeplinkUrl + '\'' +
                ", price=" + price +
                ", agents=" + agents +
                ", quoteAgeInMinutes=" + quoteAgeInMinutes +
                '}';
    }

    public String getDeeplinkUrl() {
        return deeplinkUrl;
    }

    public double getPrice() {
        return price;
    }

    public List<Integer> getAgents() {
        return agents;
    }

    public int getQuoteAgeInMinutes() {
        return quoteAgeInMinutes;
    }
}
