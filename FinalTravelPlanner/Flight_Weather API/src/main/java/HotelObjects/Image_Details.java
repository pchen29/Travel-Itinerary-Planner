package HotelObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Image_Details {
    private int width;
    private int height;
    private String url;
@JsonCreator
    public Image_Details(@JsonProperty("width") int width,
                         @JsonProperty("height") int height,
                         @JsonProperty("url") String url) {
        this.width = width;
        this.height = height;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Image_Details{" +
                "width=" + width +
                ", height=" + height +
                ", url='" + url + '\'' +
                '}';
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getUrl() {
        return url;
    }
}
