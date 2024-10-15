package tests;

import baseUrl.CollectApiBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C11_GET_ResponseBodyTestiListKullanimi extends CollectApiBaseUrl {

    /*

    https://api.collectapi.com/health/dutyPharmacy?il=Kırıkkale url’ine
    bir GET request yolladigimizda
    donen Response’in
    status code’unun 200,
    ve content type’inin Aplication.JSON,
    ve response body’sindeki
        eczane sayısıın sayisinin 4
        ve eczane’lerden birinin “DELİCE ECZANESİ”
        ve eczane ilçelerinde icinde Merkez ,Delice ve Keskin degerinin oldugunu test edin.
 */

    @Test
    public void test01(){

        specCollectApi.pathParams("pp1","health","pp2","dutyPharmacy").queryParam("il","Kirikkale");

        String apiKey="apikey 0cx0WUTXXfkl9iN3NFuE0l:1mq3qeoknSoaM3lZtimxLK";
        Response response=given().spec(specCollectApi).when().header("authorization",apiKey).get("/{pp1}/{pp2}");

        //response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType("application/json")
                .body("result.name",hasSize(5))
                .body("result.name",hasItem("DELİCE ECZANESİ"))
                .body("result.dist",hasItems("Merkez","Delice","Keskin"));
    }

}
