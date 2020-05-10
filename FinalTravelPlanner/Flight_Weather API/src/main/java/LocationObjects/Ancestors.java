package LocationObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Ancestors {
    private List<Category> subcategory;
    @JsonCreator
    public Ancestors(@JsonProperty("subcategory") List<Category> subcategory) {
        this.subcategory = subcategory;
    }

    @Override
    public String toString() {
        return "Ancestors{" +
                "subcategory=" + subcategory +
                '}';
    }

    public List<Category> getSubcategory() {
        return subcategory;
    }
}
