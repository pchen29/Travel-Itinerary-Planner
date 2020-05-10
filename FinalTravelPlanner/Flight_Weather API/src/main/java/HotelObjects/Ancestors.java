package HotelObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Ancestors {
    private String name;
    private List<Category> subcategory;
    private int location_id;
@JsonCreator
    public Ancestors(@JsonProperty("name") String name,
                     @JsonProperty("subcategory")List<Category> subcategory,
                     @JsonProperty("location_id")int location_id) {
        this.name = name;
        this.subcategory = subcategory;
        this.location_id = location_id;
    }

    @Override
    public String toString() {
        return "Ancestors{" +
                "name='" + name + '\'' +
                ", subcategory=" + subcategory +
                ", location_id=" + location_id +
                '}';
    }

    public String getName() {
        return name;
    }

    public List<Category> getSubcategory() {
        return subcategory;
    }

    public int getLocation_id() {
        return location_id;
    }
}
