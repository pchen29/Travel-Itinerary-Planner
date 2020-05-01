package LocationObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Address_Object {
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String country;
    private String postalcode;
    @JsonCreator
    public Address_Object(@JsonProperty("street1")String street1,
                          @JsonProperty("street2")String street2,
                          @JsonProperty("city")String city,
                          @JsonProperty("state")String state,
                          @JsonProperty("country")String country,
                          @JsonProperty("postalcode")String postalcode) {
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalcode = postalcode;
    }

    @Override
    public String toString() {
        return "Address_Object{" +
                "street1='" + street1 + '\'' +
                ", street2='" + street2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", postalcode='" + postalcode + '\'' +
                '}';
    }

    public String getStreet1() {
        return street1;
    }

    public String getStreet2() {
        return street2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPostalcode() {
        return postalcode;
    }
}
