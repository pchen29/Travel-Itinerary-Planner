package FlightObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Place {
    private int parentId;
    private String type;
    private int id;
    private String code;
    private String name;
@JsonCreator
    public Place(@JsonProperty("ParentId") int parentId,
                 @JsonProperty("Type")String type,
                 @JsonProperty("Id")int id,
                 @JsonProperty("Code")String code,
                 @JsonProperty("Name")String name) {
        this.parentId = parentId;
        this.type = type;
        this.id = id;
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Place{" +
                "parentId=" + parentId +
                ", type='" + type + '\'' +
                ", id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public int getParentId() {
        return parentId;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
