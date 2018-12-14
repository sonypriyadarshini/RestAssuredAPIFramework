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

public class PutCallTest {
    static Logger log = Logger.getLogger(PutorPostRequest.class);

    @Test
    public void putTest(){

        PutorPostRequest request = new PutorPostRequest();
        JSONObject requestobj = request.formPutRequest();
        int userid = 2;

        Response response = ApiCalls.putMethod(URL.baseUrl +Endpoints.COMMON.getPath()+userid,requestobj);
        JsonPath jsonPath = new JsonPath(response.asString());
        log.info("name from request "+requestobj.get("name").toString());
        log.info("name from response "+jsonPath.get("name").toString());

        Assert.assertTrue(requestobj.get("name").equals(jsonPath.get("name")));
    }
}
