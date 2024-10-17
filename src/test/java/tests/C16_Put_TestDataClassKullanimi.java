package tests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import testDatas.JsonPlaceData;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C16_Put_TestDataClassKullanimi extends JsonPlaceHolderBaseUrl {

    /*
    https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki body’e sahip
    bir PUT request yolladigimizda donen response’in
    status kodunun 200, content type’inin “application/json; charset=utf-8”,
    Connection header degerinin “keep-alive”
    ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
    Request Body
        {
            “title”: “Ahmet”,
            “body”: “Merhaba”,
            “userId”: 7,
            “id”: 70
        }
   Response Body
              {
            “title”: “Ahmet”,
            “body”: “Merhaba”,
            “userId”: 7,
            “id”: 70
        }


 */

    @Test
    public void test01() {
        specJPH.pathParams("pp1","posts","pp2","70");
        JSONObject reqBody= JsonPlaceData.jsonDataOlustur("Ahmet","Merhaba",7,70);
        JSONObject expBody= JsonPlaceData.jsonDataOlustur("Ahmet","Merhaba",7,70);

        Response response=given().contentType(ContentType.JSON).when().spec(specJPH).body(reqBody.toString()).put("/{pp1}/{pp2}");

        //response.then().assertThat().statusCode(200);
        // assert işlemlerinde önce actual sonra expected yazılırsa testng
        // assert işlemlerinde önce expected sonra actual yazılırsa junit

        assertEquals(response.getStatusCode(),JsonPlaceData.basariliSC);
        assertEquals(response.getHeader("Connection"),JsonPlaceData.header);

        JsonPath resJP=response.jsonPath();
        assertEquals(resJP.get("title"),expBody.get("title"));
        assertEquals(resJP.getString("body"),expBody.getString("body"));
        assertEquals(resJP.getInt("userId"),expBody.getInt("userId"));
        assertEquals(resJP.getInt("id"),expBody.getInt("id"));



    }
}
