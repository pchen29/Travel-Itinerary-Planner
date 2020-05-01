package LocationObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Location {
    private List<Data> data;
    private Paging paging;
    private boolean partial_content;

    @JsonCreator
    public Location(@JsonProperty("data") List<Data> data,
                    @JsonProperty("paging") Paging paging,
                    @JsonProperty("partial_content") boolean partial_content
    ) {
        this.data = data;
        this.paging = paging;
        this.partial_content = partial_content;
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "data=" + data +
                ", paging=" + paging +
                ", partial_content=" + partial_content +
                '}';
    }

    public List<Data> getData() {
        return data;
    }

    public Paging getPaging() {
        return paging;
    }


    public boolean isPartial_content() {
        return partial_content;
    }

}
