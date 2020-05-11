package AttractionObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Week_Ranges {
    private int open_time;
    private int close_time;
@JsonCreator
    public Week_Ranges(@JsonProperty("open_time") int open_time,
                       @JsonProperty("close_time") int close_time) {
        this.open_time = open_time;
        this.close_time = close_time;
    }

    @Override
    public String toString() {
        return "Week_Ranges{" +
                "open_time=" + open_time +
                ", close_time=" + close_time +
                '}';
    }

    public int getOpen_time() {
        return open_time;
    }

    public int getClose_time() {
        return close_time;
    }
}
