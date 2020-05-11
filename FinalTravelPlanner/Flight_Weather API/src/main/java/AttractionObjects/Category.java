package AttractionObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {
    private String key;
    private String name;
@JsonCreator
    public Category(@JsonProperty("key") String key,
                    @JsonProperty("name") String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "key='" + key + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

}
