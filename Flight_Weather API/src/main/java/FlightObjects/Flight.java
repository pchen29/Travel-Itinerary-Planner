package FlightObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Flight {
    private List<Agent> agents;
    private List<Carrier> carrier;
    private List<Currencies> currencies;
    private List<Itinerary> itineraries;
    private Query query;
    private String session;
    private String status;
    private List<Leg> legs;
    private List<Place> places;


    @JsonCreator
    public Flight(@JsonProperty("Agents") List<Agent> agents,
                  @JsonProperty("Carriers") List<Carrier> carriers,
                  @JsonProperty("Currencies") List<Currencies> currencies,
                  @JsonProperty("Itineraries")List<Itinerary> itineraries,
                  @JsonProperty("Query")Query query,
                  @JsonProperty("SessionKey") String session,
                  @JsonProperty("Status")String status,
                  @JsonProperty("Legs") List<Leg> legs,
                  @JsonProperty("Places")List<Place> places
    ) {
        this.agents = agents;
        this.carrier = carriers;

        this.currencies = currencies;
        this.itineraries = itineraries;
        this.query = query;
        this.session = session;
        this.status = status;
        this.legs = legs;
        this.places = places;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "agents=" + agents +
                ", carrier=" + carrier +
                ", currencies=" + currencies +
                ", itineraries=" + itineraries +
                ", query=" + query +
                ", session='" + session + '\'' +
                ", status='" + status + '\'' +
                ", legs=" + legs +
                ", places=" + places +
                '}';
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public List<Carrier> getCarrier() {
        return carrier;
    }

    public List<Currencies> getCurrencies() {
        return currencies;
    }

    public List<Itinerary> getItineraries() {
        return itineraries;
    }

    public Query getQuery() {
        return query;
    }

    public String getSession() {
        return session;
    }

    public String getStatus() {
        return status;
    }

    public List<Leg> getLegs() {
        return legs;
    }

    public List<Place> getPlaces() {
        return places;
    }
}
