package tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class C02_GET_ResponseBilgileriAssertion {

    /*
        https://restful-booker.herokuapp.com/booking/10 url’ine
        bir GET request gonderdigimizde donen Response’un,
         status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        olduğunu test ediniz

     */
    @Test
    public void test01() {

        //1- EndPoint ve (varsa) request body hazırlamak
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- Soruda verilmişse expected Data hazırlamak
        // Soruda verilmediği için expected data hazırlanmadı.


        //3- Dönen cevabın kullanılabilmesi için bir obje içine kaydetmek
        Response response = given().when().get(url);

        System.out.println(response.then().assertThat().statusCode(200)
                .contentType("application/json; charset=utf-8")
                .statusLine("HTTP/1.1 200 OK")
                .header("Server","Cowboy"));
    }
}
