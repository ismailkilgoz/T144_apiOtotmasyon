package testDatas;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RestfulData {

    public static JSONObject bookingdatesOlustur(String checkin,String checkout){
        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin",checkin);
        bookingdates.put("checkout",checkout);

        return bookingdates;
    }

    public static JSONObject jsonDataOlustur(String firstname,String lastname, int totalprice, boolean depositpaid, JSONObject bookingdates, String additionalneeds){

        JSONObject booking=new JSONObject();
        booking.put("firstname",firstname);
        booking.put("lastname",lastname);
        booking.put("totalprice",totalprice);
        booking.put("depositpaid",depositpaid);
        booking.put("bookingdates",bookingdates);
        booking.put("additionalneeds",additionalneeds);

        return booking;
    }

    public static Map <String,Object> MapDataOlustur(){
        Map<String,Object>innerMAP=new HashMap<>();

        innerMAP.put("checkin","2021-06-01");
        innerMAP.put("checkout","2021-06-10");

        Map<String ,Object> bookingMAP=new HashMap<>();
        bookingMAP.put("firstname","Ahmet");
        bookingMAP.put("lastname","Bulut");
        bookingMAP.put("totalprice",500.0);
        bookingMAP.put("depositpaid",false);
        bookingMAP.put("bookingdates",innerMAP);
        bookingMAP.put("additionalneeds","wi-fi");

        return bookingMAP;
    }

    public static Map<String,Object> expMapOlustur(){
        Map<String,Object>expMap=new HashMap<>();
        expMap.put("bookingid",24);
        expMap.put("booking",MapDataOlustur());

        return expMap;
    }
}
