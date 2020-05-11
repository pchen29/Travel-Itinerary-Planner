package HotelObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Hotel {
    private List<Data> data;
@JsonCreator
    public Hotel(@JsonProperty("data") List<Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "data=" + data +
                '}';
    }

    public List<Data> getData() {
        return data;
    }
}
