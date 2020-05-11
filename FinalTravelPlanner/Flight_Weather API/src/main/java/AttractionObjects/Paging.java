package AttractionObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Paging {
    private String results;
    private String total_results;
@JsonCreator
    public Paging(@JsonProperty("results") String results,
                  @JsonProperty("total_results") String total_results) {
        this.results = results;
        this.total_results = total_results;
    }

    @Override
    public String toString() {
        return "Paging{" +
                "results='" + results + '\'' +
                ", total_results='" + total_results + '\'' +
                '}';
    }

    public String getResults() {
        return results;
    }

    public String getTotal_results() {
        return total_results;
    }
}
