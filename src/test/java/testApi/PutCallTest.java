package testApi;

import commons.call.ApiCalls;
import commons.endpoints.Endpoints;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import request.PutRequest;

public class PutCallTest {

    @Test
    public void putTest(){
        ApiCalls apiCalls = new ApiCalls();

        PutRequest request = new PutRequest();
        JSONObject requestobj = request.formPutRequest();
        int userid = 2;

        Response response = apiCalls.putMethod(Endpoints.commonEndpoint+userid,requestobj);
        JsonPath jsonPath = new JsonPath(response.asString());
        System.out.println("name from request "+requestobj.get("name").toString());
        System.out.println("name from response "+jsonPath.get("name").toString());
        Assert.assertTrue(requestobj.get("name").equals(jsonPath.get("name")));
    }
}
