package AttractionObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Attraction {
    private List<Data> data;
    private Paging paging;

    @JsonCreator
    public Attraction(@JsonProperty("data") List<Data> data,
                      @JsonProperty("paging") Paging paging
    ) {
        this.data = data;
        this.paging = paging;
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "data=" + data +
                ", paging=" + paging +
                '}';
    }

    public List<Data> getData() {
        return data;
    }

    public Paging getPaging() {
        return paging;
    }

}
