package HotelObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Address_Object {
    private String country;
    private String city;
    private String postal_code;
    private String street1;
    private String street2;
    private String state;
@JsonCreator
    public Address_Object(@JsonProperty("country") String country,
                          @JsonProperty("city")String city,
                          @JsonProperty("postalcode")String postal_code,
                          @JsonProperty("street1")String street1,
                          @JsonProperty("street2")String street2,
                          @JsonProperty("state")String state) {
        this.country = country;
        this.city = city;
        this.postal_code = postal_code;
        this.street1 = street1;
        this.street2 = street2;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address_Object{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", street1='" + street1 + '\'' +
                ", street2='" + street2 + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String getStreet1() {
        return street1;
    }

    public String getStreet2() {
        return street2;
    }

    public String getState() {
        return state;
    }
}
