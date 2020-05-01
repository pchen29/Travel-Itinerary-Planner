package HotelObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Awards {
    private Award_Images images;
    private int year;
    private List<String> categories;
    private String display_name;
    private String award_type;
@JsonCreator
    public Awards(@JsonProperty("images") Award_Images images,
                  @JsonProperty("year")int year,
                  @JsonProperty("categories")List<String> categories,
                  @JsonProperty("display_name")String display_name,
                  @JsonProperty("award_type")String award_type) {
        this.images = images;
        this.year = year;
        this.categories = categories;
        this.display_name = display_name;
        this.award_type = award_type;
    }

    @Override
    public String toString() {
        return "Awards{" +
                "images=" + images +
                ", year=" + year +
                ", categories=" + categories +
                ", display_name='" + display_name + '\'' +
                ", award_type='" + award_type + '\'' +
                '}';
    }

    public Award_Images getImages() {
        return images;
    }

    public int getYear() {
        return year;
    }

    public List<String> getCategories() {
        return categories;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public String getAward_type() {
        return award_type;
    }
}
