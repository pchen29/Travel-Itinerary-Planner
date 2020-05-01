package FlightObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Carrier {
    private int carrierId;
    private String name;
    @JsonCreator
    public Carrier(@JsonProperty("CarrierId") int carrierId,
                   @JsonProperty("Name") String name)
    {
        this.carrierId = carrierId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Carriers{" +
                "carrierId=" + carrierId +
                ", name='" + name + '\'' +
                '}';
    }

    public int getCarrierId() {
        return carrierId;
    }

    public String getName() {
        return name;
    }
}
