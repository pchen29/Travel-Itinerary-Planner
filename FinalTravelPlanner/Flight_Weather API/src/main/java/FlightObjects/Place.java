package FlightObjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Place {
    private int placeId;
    private String type;
    private String cityId;
    private String countryName;
    private String i_ataCode;
    private String skyscannerCode;
    private String cityName;
    private String name;
@JsonCreator
    public Place(@JsonProperty("PlaceId") int placeId,
                 @JsonProperty("Type")String type,
                 @JsonProperty("CityId")String cityId,
                 @JsonProperty("CountryName")String countryName,
                 @JsonProperty("IataCode")String i_ataCode,
                 @JsonProperty("SkyscannerCode")String skyscannerCode,
                 @JsonProperty("CityName")String cityName,
                 @JsonProperty("Name")String name) {
        this.placeId = placeId;
        this.type = type;
        this.cityId = cityId;
        this.countryName = countryName;
        this.i_ataCode = i_ataCode;
        this.skyscannerCode = skyscannerCode;
        this.cityName = cityName;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Place{" +
                "placeId=" + placeId +
                ", type='" + type + '\'' +
                ", cityId='" + cityId + '\'' +
                ", countryName='" + countryName + '\'' +
                ", i_ataCode='" + i_ataCode + '\'' +
                ", skyscannerCode='" + skyscannerCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public int getPlaceId() {
        return placeId;
    }

    public String getType() {
        return type;
    }

    public String getCityId() {
        return cityId;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getI_ataCode() {
        return i_ataCode;
    }

    public String getSkyscannerCode() {
        return skyscannerCode;
    }

    public String getCityName() {
        return cityName;
    }

    public String getName() {
        return name;
    }
}
