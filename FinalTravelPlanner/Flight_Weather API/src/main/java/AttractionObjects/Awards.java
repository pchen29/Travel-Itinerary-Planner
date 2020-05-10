package AttractionObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Awards {
    private int year;
    private Award_Images images;
    private String display_name;
    private String award_type;
@JsonCreator
    public Awards(@JsonProperty("year")int year,
                  @JsonProperty("images")Award_Images images,
                  @JsonProperty("display_name")String display_name,
                  @JsonProperty("award_type")String award_type) {
        this.year = year;
        this.images = images;
        this.display_name = display_name;
        this.award_type = award_type;
    }


}
