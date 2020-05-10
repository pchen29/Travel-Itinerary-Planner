package AttractionObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Search_explanations {
    private String mentioned_by_travelers;

    @JsonCreator
    public Search_explanations(@JsonProperty("mentioned_by_travelers") String mentioned_by_travelers) {
        this.mentioned_by_travelers = mentioned_by_travelers;
    }

    @Override
    public String toString() {
        return "Search_explanations{" +
                "mentioned_by_travelers='" + mentioned_by_travelers + '\'' +
                '}';
    }

    public String getMentioned_by_travelers() {
        return mentioned_by_travelers;
    }
}
