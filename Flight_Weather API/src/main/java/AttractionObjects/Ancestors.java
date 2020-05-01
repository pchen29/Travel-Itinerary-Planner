package AttractionObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Ancestors {
    private String name;
    private List<Category> subcategory;
    @JsonCreator
    public Ancestors(@JsonProperty("subcategory") List<Category> subcategory,
                     @JsonProperty("name") String name
    ) {
        this.subcategory = subcategory;
        this.name=name;
    }

    @Override
    public String toString() {
        return "Ancestors{" +
                "name='" + name + '\'' +
                ", subcategory=" + subcategory +
                '}';
    }

    public String getName() {
        return name;
    }

    public List<Category> getSubcategory() {
        return subcategory;
    }
}
