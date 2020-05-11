package HotelObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Photo {
    private Images images;
    private String caption;
@JsonCreator
    public Photo(@JsonProperty("images") Images images,
                 @JsonProperty("caption") String caption) {
        this.images = images;
        this.caption = caption;
    }
}
