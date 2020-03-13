package FlightObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Carrier {
    private String imageURL;
    private int id;
    private String code;
    private String name;
    private String displayCode;

    @JsonCreator
    public Carrier(@JsonProperty("ImageUrl") String imageURL,
                   @JsonProperty("Id") int id,
                   @JsonProperty("Code") String code ,
                   @JsonProperty("Name") String name,
                   @JsonProperty("DisplayCode") String displayCode){
        this.imageURL=imageURL;
        this.id=id;
        this.code=code;
        this.name=name;
        this.displayCode=displayCode;
    }

    @Override
    public String toString() {
        return "Carrier{" +
                "imageURL='" + imageURL + '\'' +
                ", id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", displayCode='" + displayCode + '\'' +
                '}';
    }

    public String getImageURL() {
        return imageURL;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDisplayCode() {
        return displayCode;
    }
}
