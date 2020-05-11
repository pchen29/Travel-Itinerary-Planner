package AttractionObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Award_Images {
    private String small;
    private String large;
@JsonCreator
    public Award_Images(@JsonProperty("small") String small,
                        @JsonProperty("large") String large) {
        this.small = small;
        this.large = large;
    }

    @Override
    public String toString() {
        return "Award_Images{" +
                "small='" + small + '\'' +
                ", large='" + large + '\'' +
                '}';
    }

    public String getSmall() {
        return small;
    }

    public String getLarge() {
        return large;
    }
}
