package tests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import testDatas.JsonPlaceData;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class C18_PUT_DeSerialization extends JsonPlaceHolderBaseUrl {

    /*
            https://jsonplaceholder.typicode.com/posts/70 url'ine
            asagidaki body’e sahip bir PUT request yolladigimizda
            donen response’in response body’sinin
            asagida verilen ile ayni oldugunu test ediniz
            Request Body
            {
                "title": "Ahmet",
                "body": "Merhaba",
                "userId": 10,
                "id": 70
            }

            Expected Data :
            {
                "title": "Ahmet",
                "body": "Merhaba",
                "userId": 10,
                "id": 70
            }

     */

    @Test
    public void deSerialization(){
        //1- EndPoint ve RequestBody hazırlama
        specJPH.pathParams("pp1","posts","pp2","70");
        Map<String, Object> reqMAPBody= JsonPlaceData.MAPDataOlustur("Ahmet","Merhaba",10.0,70.0);

        //2-Expected Body tanımlandı
        Map<String, Object> expMAPBody= JsonPlaceData.MAPDataOlustur("Ahmet","Merhaba",10.0,70.0);

        //3-Response değer kaydedildi.
        Response response=given().spec(specJPH).contentType(ContentType.JSON).when().body(reqMAPBody).put("/{pp1}/{pp2}");

        //response.prettyPrint();

        //4-Assertion ve gelen cevabın Map olarak kaydedilmesi
        Map<String, Object> resMAP=response.as(HashMap.class);

        assertEquals(expMAPBody.get("title"),resMAP.get("title"));
        assertEquals(expMAPBody.get("body"),resMAP.get("body"));
        assertEquals(expMAPBody.get("userId"),resMAP.get("userId"));
        assertEquals(expMAPBody.get("id"),resMAP.get("id"));

    }
}
