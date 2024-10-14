package tests;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class C03_jSONObjesiOlusturma {

    /*

    Asagidaki JSON Objesini olusturup konsolda yazdirin.

	{
	"title":"Ahmet",
	"body":"Merhaba",
	"userId":1
	}


 */

    @Test
    public void dataCreate(){
        JSONObject data = new JSONObject();
        data.put("title","Ahmet");
        data.put("body","Merhaba");
        data.put("userId",1);

        System.out.println(data);
    }

    /*
        {
     "firstname":"Jim",
     "additionalneeds":"Breakfast",
     "bookingdates": {
             "checkin":"2018-01-01",
             "checkout":"2019-01-01"
                    },
      "totalprice":111,
      "depositpaid":true,
      "lastname":"Brown"
 }

 */

    @Test
    public void dataUpdate(){
        JSONObject updatedData=new JSONObject();

        // ic ice datalar varsa once en icteki data olusturulur
        JSONObject innerData=new JSONObject();
        innerData.put("checkin","2018-01-01");
        innerData.put("checkout","2019-01-01");

        updatedData.put("firstname","Jim");
        updatedData.put("additionalneeds","Breakfast");
        updatedData.put("bookingdates",innerData);
        updatedData.put("totalprice",111);
        updatedData.put("depositpaid",true);
        updatedData.put("lastname","Brown");

        System.out.println("updatedData = " + updatedData);
    }
}
