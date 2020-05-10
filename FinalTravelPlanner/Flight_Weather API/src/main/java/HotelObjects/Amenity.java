package HotelObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Amenity {
    private String name;
    private String key;
@JsonCreator
    public Amenity(@JsonProperty("name")String name,
                   @JsonProperty("key") String key) {
        this.name = name;
        this.key = key;
    }

    @Override
    public String toString() {
        return "Amenity{" +
                "name='" + name + '\'' +
                ", key='" + key + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }
}
