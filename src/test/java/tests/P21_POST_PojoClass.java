package tests;

import baseUrl.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.RestfulBookingdatesPOJO;
import pojos.RestfulExpBodyPOJO;
import pojos.RestfulReqBodyPOJO;

import static io.restassured.RestAssured.given;

public class P21_POST_PojoClass extends RestfulBaseUrl {

    /*
    https://restful-booker.herokuapp.com/booking url’ine
asagidaki body’ye sahip bir POST request gonderdigimizde
donen response’un id haric asagidaki gibi oldugunu test edin.
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
Response Body // expected data
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

        RestfulBookingdatesPOJO bookingdatesPOJO = new RestfulBookingdatesPOJO("2024-09-30","2024-10-30");
        RestfulReqBodyPOJO reqPOJO=new RestfulReqBodyPOJO("Ahmet","Bulut",500,false,bookingdatesPOJO,"wi-fi");

        RestfulExpBodyPOJO expPOJO=new RestfulExpBodyPOJO(24,reqPOJO);

        Response response=given().spec(specRestfull).contentType(ContentType.JSON).when().body(reqPOJO).post("/{pp1}");

        RestfulExpBodyPOJO resPOJO=response.as(RestfulExpBodyPOJO.class);

        Assert.assertEquals(expPOJO.getBooking().getFirstname(),resPOJO.getBooking().getFirstname());
        Assert.assertEquals(expPOJO.getBooking().getLastname(),resPOJO.getBooking().getLastname());
        Assert.assertEquals(expPOJO.getBooking().getTotalprice(),resPOJO.getBooking().getTotalprice());
        Assert.assertEquals(expPOJO.getBooking().getAdditionalneeds(),resPOJO.getBooking().getAdditionalneeds());
        Assert.assertEquals(expPOJO.getBooking().isDepositpaid(),resPOJO.getBooking().isDepositpaid());
        Assert.assertEquals(expPOJO.getBooking().getBookingdates().getCheckin(),resPOJO.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(expPOJO.getBooking().getBookingdates().getCheckout(),resPOJO.getBooking().getBookingdates().getCheckout());
    }
}
