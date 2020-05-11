package AttractionObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Attraction {
    private List<Data> data;
    private Filter filter;
    private Paging paging;

    @JsonCreator
    public Attraction(@JsonProperty("data") List<Data> data,
                      @JsonProperty("paging") Paging paging,
                      @JsonProperty("filters") Filter filter
    ) {
        this.data = data;
        this.paging = paging;
        this.filter=filter;
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "data=" + data +
                ", filter=" + filter +
                ", paging=" + paging +
                '}';
    }

    public List<Data> getData() {
        return data;
    }

    public Paging getPaging() {
        return paging;
    }

    public Filter getFilter() {
        return filter;
    }
}
