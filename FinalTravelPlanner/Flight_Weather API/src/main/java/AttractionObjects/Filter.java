package AttractionObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Filter {
    private SubType subTypes;
    private SubCategory subCategory;

    @JsonCreator
    public Filter(@JsonProperty("subtype") SubType subTypes,
                  @JsonProperty("subcategory") SubCategory subCategory
    ) {
        this.subTypes = subTypes;
        this.subCategory=subCategory;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "subTypes=" + subTypes +
                ", subCategory=" + subCategory +
                '}';
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public SubType getSubTypes() {
        return subTypes;
    }
}
