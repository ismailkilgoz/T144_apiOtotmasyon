package testDatas;

import org.json.JSONObject;

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
}
