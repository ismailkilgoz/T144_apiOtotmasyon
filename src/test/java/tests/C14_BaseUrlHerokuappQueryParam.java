package tests;

import baseUrl.RestfulBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C14_BaseUrlHerokuappQueryParam extends RestfulBaseUrl {

    /*

    https://restful-booker.herokuapp.com/booking endpointine
    gerekli Query parametrelerini yazarak
    “firstname” degeri “Eric” olan rezervasyon oldugunu test edecek
    bir GET request gonderdigimizde, donen response’un status code’unun
    200 oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin

 */

    @Test //baseurl'de test notasyonu testNG ile ayarladığı için buradak @Test notasyonu da testNG olmalıdır
    public void test01(){

        specRestfull.pathParam("pp1","booking").queryParam("firstname","Eric");

        Response response=given().spec(specRestfull).when().get("/{pp1}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).body("size()", greaterThan(0));

    }

    /*
        https://restful-booker.herokuapp.com/booking endpointine
        gerekli Query parametrelerini yazarak
        “firstname” degeri “Jim” ve “lastname” degeri “Brown” olan rezervasyon oldugunu
        test edecek bir GET request gonderdigimizde,
        donen response’un status code’unun 200 oldugunu ve
        “Jim Jackson” ismine sahip en az bir booking oldugunu test edin

  */
    @Test
    public void test02(){
        specRestfull.pathParam("pp1","booking").queryParams("firstname","Jim","lastname","Brown");

        Response response=given().spec(specRestfull).when().get("/{pp1}");
        //https://restful-booker.herokuapp.com/booking?firstname=Jim&lastname=Brown
        //contenType(ContenType.JSON) ifadesi genelde veri(reqBody) gönderdiğimizde(POST-PUT-PATCH) yazarız.
        response.prettyPrint();
        response.then().assertThat().statusCode(200).body("size()",greaterThan(0));
    }
}
