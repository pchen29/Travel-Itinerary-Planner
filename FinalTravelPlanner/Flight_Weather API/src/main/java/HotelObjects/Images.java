package HotelObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Images {
    private Image_Details small;
    private Image_Details thumbnail;
    private Image_Details original;
    private Image_Details large;
    private Image_Details medium;
@JsonCreator
    public Images(@JsonProperty("small") Image_Details small,
                  @JsonProperty("thumbnail")Image_Details thumbnail,
                  @JsonProperty("original")Image_Details original,
                  @JsonProperty("large")Image_Details large,
                  @JsonProperty("medium")Image_Details medium) {
        this.small = small;
        this.thumbnail = thumbnail;
        this.original = original;
        this.large = large;
        this.medium = medium;
    }

    @Override
    public String toString() {
        return "Images{" +
                "small=" + small +
                ", thumbnail=" + thumbnail +
                ", original=" + original +
                ", large=" + large +
                ", medium=" + medium +
                '}';
    }

    public Image_Details getSmall() {
        return small;
    }

    public Image_Details getThumbnail() {
        return thumbnail;
    }

    public Image_Details getOriginal() {
        return original;
    }

    public Image_Details getLarge() {
        return large;
    }

    public Image_Details getMedium() {
        return medium;
    }
}
