package testApi;

import commons.call.ApiCalls;
import commons.endpoints.Endpoints;
import commons.endpoints.URL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


/* this is the test class for checking GET call.
* the actual GET call is written in Apicalls class in the helper
* Respose is checked here using JSONPath
* */

public class GetCallTest {
    static Logger log = Logger.getLogger(GetCallTest.class);

    @Test
    public void getTest(){

        //call the get call method from ApiCalls
        int userid = 2;
        Response response = ApiCalls.getMethod(URL.baseUrl +Endpoints.COMMON.getPath()+userid);

        //convert the response received from get call into a jsonpath object
        JsonPath jsonPath = new JsonPath(response.asString());

        //parse though the response using jsonpath
        log.info("Data "+jsonPath.get("data[0].name"));
        Assert.assertTrue(response.getStatusCode()==200);
    }
}
