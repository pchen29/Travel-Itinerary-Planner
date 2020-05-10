package AttractionObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Hours {
    private String timezone;
    private List<List<Week_Ranges>> week_ranges;
@JsonCreator
    public Hours(@JsonProperty("timezone") String timezone,
                 @JsonProperty("week_ranges") List<List<Week_Ranges>> week_ranges) {
        this.timezone = timezone;
        this.week_ranges = week_ranges;
    }

    @Override
    public String toString() {
        return "Hours{" +
                "timezone='" + timezone + '\'' +
                ", week_ranges=" + week_ranges +
                '}';
    }

    public String getTimezone() {
        return timezone;
    }

    public List<List<Week_Ranges>> getWeek_ranges() {
        return week_ranges;
    }
}
