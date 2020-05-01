package HotelObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Neighborhood_info {
    private String name;
    private int location_id;
@JsonCreator
    public Neighborhood_info(@JsonProperty("name") String name,
                             @JsonProperty("location_id") int location_id) {
        this.name = name;
        this.location_id = location_id;
    }

    @Override
    public String toString() {
        return "Neighborhood_info{" +
                "name='" + name + '\'' +
                ", location_id=" + location_id +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getLocation_id() {
        return location_id;
    }
}
