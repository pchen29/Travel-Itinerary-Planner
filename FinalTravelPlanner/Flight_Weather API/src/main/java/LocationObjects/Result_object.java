package LocationObjects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Result_object {
    private Address_Object address_object;
    private String distance;
    private String timezone;
    private double latitude;
    private double longitude;
    private int location_id;
    private List<Ancestors> ancestors;
    private boolean is_closed;
    private boolean is_long_closed;
    private String location_string;
    private String geo_description;
    private String name;
    private Category category;
    private List<Category> subcategory;

    public Result_object(@JsonProperty("address_obj")Address_Object address_object,
                         @JsonProperty("distance")String distance,
                         @JsonProperty("timezone")String timezone,
                         @JsonProperty("latitude")double latitude,
                         @JsonProperty("longitude")double longitude,
                         @JsonProperty("location_id")int location_id,
                         @JsonProperty("ancestors")List<Ancestors> ancestors,
                         @JsonProperty("is_closed")boolean is_closed,
                         @JsonProperty("is_long_closed")boolean is_long_closed,
                         @JsonProperty("location_string")String location_string,
                         @JsonProperty("geo_description")String geo_description,
                         @JsonProperty("name")String name,
                         @JsonProperty("category")Category category,
                         @JsonProperty("subcategory")List<Category> subcategory
    ) {
        this.address_object = address_object;
        this.distance = distance;
        this.timezone = timezone;
        this.latitude = latitude;
        this.longitude = longitude;
        this.location_id = location_id;
        this.ancestors = ancestors;
        this.is_closed = is_closed;
        this.is_long_closed = is_long_closed;
        this.location_string = location_string;
        this.geo_description = geo_description;
        this.name = name;
        this.category = category;
        this.subcategory = subcategory;
    }

    @Override
    public String toString() {
        return "Result_object{" +
                "address_object=" + address_object +
                ", distance='" + distance + '\'' +
                ", timezone='" + timezone + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", location_id=" + location_id +
                ", ancestors=" + ancestors +
                ", is_closed=" + is_closed +
                ", is_long_closed=" + is_long_closed +
                ", location_string='" + location_string + '\'' +
                ", geo_description='" + geo_description + '\'' +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", subcategory=" + subcategory +
                '}';
    }

    public Address_Object getAddress_object() {
        return address_object;
    }

    public String getDistance() {
        return distance;
    }

    public String getTimezone() {
        return timezone;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getLocation_id() {
        return location_id;
    }

    public List<Ancestors> getAncestors() {
        return ancestors;
    }

    public boolean isIs_closed() {
        return is_closed;
    }

    public boolean isIs_long_closed() {
        return is_long_closed;
    }

    public String getLocation_string() {
        return location_string;
    }

    public String getGeo_description() {
        return geo_description;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public List<Category> getSubcategory() {
        return subcategory;
    }
}
