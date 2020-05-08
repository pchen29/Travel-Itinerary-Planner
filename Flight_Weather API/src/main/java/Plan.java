import AttractionObjects.Data;

import java.util.ArrayList;
import java.util.List;

public class Plan {
    private String outboundFlight;
    private String inboundFlight;
    private List<String> hotels;
    private List<List<String>> days;

    public Plan(String outboundFlight, String inboundFlight, List<List<HotelObjects.Data>> hotels, List<List<List<Data>>> days) {
        this.outboundFlight = outboundFlight;
        this.inboundFlight = inboundFlight;
        List<String> hotelList=new ArrayList<>();
        for (List<HotelObjects.Data> hotelsList:hotels){
            for (HotelObjects.Data hotel:hotelsList){
                hotelList.add("Hotel: "+hotel.getName()+ " Price: "+ hotel.getPrice());
            }
        }
        this.hotels = hotelList;
        //for ()
        //this.days = days;
    }


}
