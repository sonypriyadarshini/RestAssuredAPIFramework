package testApi;

import commons.call.ApiCalls;
import commons.endpoints.Endpoints;
import commons.endpoints.URL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/* this is the test class for checking POST call.
* the actual POST call is written in Apicalls class in the helper
* Request is built here using JSONObject.
* Response is checked here using JSONPath
*/

public class PostCallTest {
    static Logger log = Logger.getLogger(PostCallTest.class);

    @Test
    public void postCallTest(){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", RandomStringUtils.randomAlphabetic(5));
        jsonObject.put("job", RandomStringUtils.randomAlphanumeric(10).toUpperCase());

        Response response = ApiCalls.postMethod(URL.baseUrl +Endpoints.COMMON.getPath(),jsonObject);
        JsonPath jsonPath = new JsonPath(response.asString());
        log.info("name from request "+jsonObject.get("name").toString());
        log.info("name from response "+jsonPath.get("name").toString());

        Assert.assertTrue(jsonObject.get("name").equals(jsonPath.get("name")));
    }
}
