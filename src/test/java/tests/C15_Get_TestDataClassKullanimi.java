package tests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import testDatas.JsonPlaceData;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C15_Get_TestDataClassKullanimi extends JsonPlaceHolderBaseUrl {

    /*

     https://jsonplaceholder.typicode.com/posts/22 url’ine bir
    GET request yolladigimizda donen response’in
    status kodunun 200 ve
    response body’sinin asagida verilen ile ayni oldugunu test ediniz
      Response body : (expected data)
    {
        “userId”: 3,
        “id”: 22,
        “title”: “dolor sint quo a velit explicabo quia nam”,
        “body”: “eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse”
}

 */

    @Test
    public void testDataKullanimi(){
        specJPH.pathParams("pp1","posts","pp2","22");

        JSONObject expBody= JsonPlaceData.expBodyOlustur();
        Response response=given().when().spec(specJPH).get("/{pp1}/{pp2}");

        JsonPath resJP = response.jsonPath();

        assertEquals(response.getStatusCode(),JsonPlaceData.basariliSC);
        assertEquals(resJP.getInt("userId"),expBody.get("userId"));
        assertEquals(resJP.getInt("id"),expBody.get("id"));
        assertEquals(resJP.getString("title"),expBody.get("title"));
        assertEquals(resJP.getString("body"),expBody.get("body"));
    }
}
