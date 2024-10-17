package tests;

import baseUrl.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import testDatas.JsonPlaceData;
import testDatas.RestfulData;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C17_Post_TestDataKullanimi extends RestfulBaseUrl {

    /*
       https://restful-booker.herokuapp.com/booking url’ine asagidaki body’ye sahip
        bir POST request gonderdigimizde donen response’un
        id haric asagidaki gibi oldugunu test edin.

        Request body
               {
                   “firstname” : “Ahmet”,
                   “lastname” : “Bulut”,
                   “totalprice” : 500,
                   “depositpaid” : false,
                   “bookingdates” : {
                       “checkin” : “2021-06-01”,
                       “checkout” : “2021-06-10”
                   },
                   “additionalneeds” : “wi-fi”
               }
        Response Body
         {
            “bookingid”: 24,
            “booking”: {
                “firstname”: “Ahmet”,
                “lastname”: “Bulut”,
                “totalprice”: 500,
                “depositpaid”: false,
                “bookingdates”: {
                    “checkin”: “2021-06-01",
                    “checkout”: “2021-06-10"
                },
                “additionalneeds”: “wi-fi”
            }
        }
         */

    @Test
    public void test01(){
        specRestfull.pathParam("pp1","booking");

        JSONObject bookingdates=RestfulData.bookingdatesOlustur("2021-06-01","2021-06-10");
        JSONObject reqBody= RestfulData.jsonDataOlustur("Ahmet","Bulut",500,false,bookingdates,"wi-fi");

        JSONObject expBody = new JSONObject();
        expBody.put("bookingid",24);
        expBody.put("booking",reqBody);

        Response response=given().contentType(ContentType.JSON).when().spec(specRestfull).body(reqBody.toString()).post("/{pp1}" );

        JsonPath resJP=response.jsonPath();

        assertEquals(expBody.getJSONObject("booking").get("firstname"),resJP.get("booking.firstname"));
        assertEquals(expBody.getJSONObject("booking").get("lastname"),resJP.get("booking.lastname"));
        assertEquals(expBody.getJSONObject("booking").get("totalprice"),resJP.get("booking.totalprice"));
        assertEquals(expBody.getJSONObject("booking").get("depositpaid"),resJP.get("booking.depositpaid"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),resJP.get("booking.bookingdates.checkin"));
        assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),resJP.get("booking.bookingdates.checkout"));
        assertEquals(expBody.getJSONObject("booking").get("additionalneeds"),resJP.get("booking.additionalneeds"));

    }

}
