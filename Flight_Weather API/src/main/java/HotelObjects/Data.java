package HotelObjects;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Data {
    private double rating;
    private List<Neighborhood_info> neighborhood_info;
    private List<Ancestors> ancestors;
    private Address_Object address_object;
    private List<Amenity> amenities;
    private Photo photo;
    private List<Awards> awards;
    private Category category;
    private int locationId;
    private String price;
    private int ranking_geo_id;
    private double longitude;
    private double latitude;
    private String name;
    private String phone;
    private String local_address;
    private String address;
    private String description;
    private String hotel_class;
    private String website;
    private String ranking_geo;
    private String location_string;
    private String tripAdvisor_web_url;
    private String priceLevel;
    private String ranking;
@JsonCreator
    public Data(@JsonProperty("rating") double rating,
                @JsonProperty("neighborhood_info")List<Neighborhood_info> neighborhood_info,
                @JsonProperty("ancestors")List<Ancestors> ancestors,
                @JsonProperty("address_obj")Address_Object address_object,
                @JsonProperty("amenities")List<Amenity> amenities,
                @JsonProperty("photo")Photo photo,
                @JsonProperty("awards")List<Awards> awards,
                @JsonProperty("category")Category category,
                @JsonProperty("location_id")int locationId,
                @JsonProperty("price")String price,
                @JsonProperty("ranking_geo_id")int ranking_geo_id,
                @JsonProperty("longitude")double longitude,
                @JsonProperty("latitude")double latitude,
                @JsonProperty("name")String name,
                @JsonProperty("phone")String phone,
                @JsonProperty("local_address")String local_address,
                @JsonProperty("address")String address,
                @JsonProperty("description")String description,
                @JsonProperty("hotel_class")String hotel_class,
                @JsonProperty("website")String website,
                @JsonProperty("ranking_geo")String ranking_geo,
                @JsonProperty("location_string")String location_string,
                @JsonProperty("web_url")String tripAdvisor_web_url,
                @JsonProperty("price_level")String priceLevel,
                @JsonProperty("ranking")String ranking) {
        this.rating = rating;
        this.neighborhood_info = neighborhood_info;
        this.ancestors = ancestors;
        this.address_object = address_object;
        this.amenities = amenities;
        this.photo = photo;
        this.awards = awards;
        this.category = category;
        this.locationId = locationId;
        this.price = price;
        this.ranking_geo_id = ranking_geo_id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
        this.phone = phone;
        this.local_address = local_address;
        this.address = address;
        this.description = description;
        this.hotel_class = hotel_class;
        this.website = website;
        this.ranking_geo = ranking_geo;
        this.location_string = location_string;
        this.tripAdvisor_web_url = tripAdvisor_web_url;
        this.priceLevel = priceLevel;
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "Data{" +
                "rating=" + rating +
                ", neighborhood_info=" + neighborhood_info +
                ", ancestors=" + ancestors +
                ", address_object=" + address_object +
                ", amenities=" + amenities +
                ", photo=" + photo +
                ", awards=" + awards +
                ", category=" + category +
                ", locationId=" + locationId +
                ", price='" + price + '\'' +
                ", ranking_geo_id=" + ranking_geo_id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", local_address='" + local_address + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", hotel_class='" + hotel_class + '\'' +
                ", website='" + website + '\'' +
                ", ranking_geo='" + ranking_geo + '\'' +
                ", location_string='" + location_string + '\'' +
                ", tripAdvisor_web_url='" + tripAdvisor_web_url + '\'' +
                ", priceLevel='" + priceLevel + '\'' +
                ", ranking='" + ranking + '\'' +
                '}';
    }

    public double getRating() {
        return rating;
    }

    public List<Neighborhood_info> getNeighborhood_info() {
        return neighborhood_info;
    }

    public List<Ancestors> getAncestors() {
        return ancestors;
    }

    public Address_Object getAddress_object() {
        return address_object;
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public Photo getPhoto() {
        return photo;
    }

    public List<Awards> getAwards() {
        return awards;
    }

    public Category getCategory() {
        return category;
    }

    public int getLocationId() {
        return locationId;
    }

    public String getPrice() {
        return price;
    }

    public int getRanking_geo_id() {
        return ranking_geo_id;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getLocal_address() {
        return local_address;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public String getHotel_class() {
        return hotel_class;
    }

    public String getWebsite() {
        return website;
    }

    public String getRanking_geo() {
        return ranking_geo;
    }

    public String getLocation_string() {
        return location_string;
    }

    public String getTripAdvisor_web_url() {
        return tripAdvisor_web_url;
    }

    public String getPriceLevel() {
        return priceLevel;
    }

    public String getRanking() {
        return ranking;
    }
}
