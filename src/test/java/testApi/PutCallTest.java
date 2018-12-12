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
import request.PutRequest;

public class PutCallTest {
    static Logger log = Logger.getLogger(PutRequest.class);

    @Test
    public void putTest(){

        PutRequest request = new PutRequest();
        JSONObject requestobj = request.formPutRequest();
        int userid = 2;

        Response response = ApiCalls.putMethod(URL.baseUrl +Endpoints.COMMON.getPath()+userid,requestobj);
        JsonPath jsonPath = new JsonPath(response.asString());
        log.info("name from request "+requestobj.get("name").toString());
        log.info("name from response "+jsonPath.get("name").toString());

        Assert.assertTrue(requestobj.get("name").equals(jsonPath.get("name")));
    }
}
