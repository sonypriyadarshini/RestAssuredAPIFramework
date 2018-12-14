package testApi;

import commons.call.ApiCalls;
import commons.endpoints.Endpoints;
import commons.endpoints.URL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import request.PutorPostRequest;

/* this is the test class for checking POST call.
* the actual POST call is written in Apicalls class in the helper
* Request is built here using JSONObject.
* Response is checked here using JSONPath
*/

public class PostCallTest {
    static Logger log = Logger.getLogger(PostCallTest.class);

    @Test
    public void postCallTest(){

        //form request for the API
        PutorPostRequest request = new PutorPostRequest();
        JSONObject requestobj = request.formPutRequest();

        //make the post apicall
        Response response = ApiCalls.postMethod(URL.baseUrl +Endpoints.COMMON.getPath(),requestobj);

        //convert response into jspnpath object and parse through it
        JsonPath jsonPath = new JsonPath(response.asString());
        log.info("name from request "+requestobj.get("name").toString());
        log.info("name from response "+jsonPath.get("name").toString());

        Assert.assertTrue(requestobj.get("name").equals(jsonPath.get("name")));
    }
}
