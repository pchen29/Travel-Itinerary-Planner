package AttractionObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Data {
    private Address_Object address_object;
    private String timezone;
    private double latitude;
    private double longitude;
    private double rating;
    private String description;
    private int location_id;
    private List<Category> subtype;
    private int ranking_geo_id;
    private String ranking_geo;
    private List<Ancestors> ancestors;
    private String email;
    private String website;
    private Hours hours;
    private String address;
    private String subcategory_ranking;
    private String web_url;
    private String phone;
    private List<Awards> awards;
    private String name;
    private int num_reviews;
    private Category category;
    private List<Category> subcategory;

@JsonCreator
    public Data(@JsonProperty("address_object") Address_Object address_object,
                @JsonProperty("timezone") String timezone,
                @JsonProperty("latitude")double latitude,
                @JsonProperty("longitude")double longitude,
                @JsonProperty("rating")double rating,
                @JsonProperty("description")String description,
                @JsonProperty("location_id")int location_id,
                @JsonProperty("subtype")List<Category> subtype,
                @JsonProperty("ranking_geo_id")int ranking_geo_id,
                @JsonProperty("ranking_geo")String ranking_geo,
                @JsonProperty("ancestors")List<Ancestors> ancestors,
                @JsonProperty("email")String email,
                @JsonProperty("website")String website,
                @JsonProperty("hours")Hours hours,
                @JsonProperty("address")String address,
                @JsonProperty("subcategory_ranking")String subcategory_ranking,
                @JsonProperty("web_url")String web_url,
                @JsonProperty("phone")String phone,
                @JsonProperty("awards")List<Awards> awards,
                @JsonProperty("name")String name,
                @JsonProperty("num_reviews")int num_reviews,
                @JsonProperty("category")Category category,
                @JsonProperty("subcategory")List<Category> subcategory) {
        this.address_object = address_object;
        this.timezone=timezone;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rating = rating;
        this.description = description;
        this.location_id = location_id;
        this.subtype = subtype;
        this.ranking_geo_id = ranking_geo_id;
        this.ranking_geo = ranking_geo;
        this.ancestors = ancestors;
        this.email = email;
        this.website = website;
        this.hours = hours;
        this.address = address;
        this.subcategory_ranking = subcategory_ranking;
        this.web_url = web_url;
        this.phone = phone;
        this.awards = awards;
        this.name = name;
        this.num_reviews = num_reviews;
        this.category = category;
        this.subcategory = subcategory;
    }

    @Override
    public String toString() {
        return "Data{" +
                ", name='" + name + '\'' +
                "address_object=" + address_object +
                ", timezone='" + timezone + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", location_id=" + location_id +
                ", subtype=" + subtype +
                ", ranking_geo_id=" + ranking_geo_id +
                ", ranking_geo='" + ranking_geo + '\'' +
                ", ancestors=" + ancestors +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                ", hours=" + hours +
                ", address='" + address + '\'' +
                ", subcategory_ranking='" + subcategory_ranking + '\'' +
                ", web_url='" + web_url + '\'' +
                ", phone='" + phone + '\'' +
                ", awards=" + awards +
                ", num_reviews=" + num_reviews +
                ", category=" + category +
                ", subcategory=" + subcategory +
                '}';
    }

    public String getTimezone() {
        return timezone;
    }

    public Address_Object getAddress_object() {
        return address_object;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public int getLocation_id() {
        return location_id;
    }

    public List<Category> getSubtype() {
        return subtype;
    }

    public int getRanking_geo_id() {
        return ranking_geo_id;
    }

    public String getRanking_geo() {
        return ranking_geo;
    }

    public List<Ancestors> getAncestors() {
        return ancestors;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }

    public Hours getHours() {
        return hours;
    }

    public String getAddress() {
        return address;
    }

    public String getSubcategory_ranking() {
        return subcategory_ranking;
    }

    public String getWeb_url() {
        return web_url;
    }

    public String getPhone() {
        return phone;
    }

    public List<Awards> getAwards() {
        return awards;
    }

    public String getName() {
        return name;
    }

    public int getNum_reviews() {
        return num_reviews;
    }

    public Category getCategory() {
        return category;
    }

    public List<Category> getSubcategory() {
        return subcategory;
    }
}
