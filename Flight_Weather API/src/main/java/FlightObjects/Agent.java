package FlightObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Agent {
    private String status;
    private String type;
    private String imageUrl;
    private int id;
    private boolean optimisedForMobile;
    private String name;

    @JsonCreator
    public Agent(@JsonProperty("Status") String status,
                 @JsonProperty("Type") String type,
                 @JsonProperty("ImageUrl") String imageUrl,
                 @JsonProperty("Id") int id,
                 @JsonProperty("OptimisedForMobile") boolean optimisedForMobile,
                 @JsonProperty("Name") String name) {
        this.status = status;
        this.type = type;
        this.imageUrl = imageUrl;
        this.id = id;
        this.optimisedForMobile = optimisedForMobile;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "status='" + status + '\'' +
                ", type='" + type + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", id=" + id +
                ", optimisedForMobile=" + optimisedForMobile +
                ", name='" + name + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getId() {
        return id;
    }

    public boolean isOptimisedForMobile() {
        return optimisedForMobile;
    }

    public String getName() {
        return name;
    }
}
