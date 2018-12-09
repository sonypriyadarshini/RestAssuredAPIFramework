package testApi;

import helper.ApiCalls;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;


/* this is the test class for checking GET call.
* the actual GET call is written in Apicalls class in the helper
* Respose is checked here using JSONPath
* */

public class GetCall {
    @Test
    public void getTest(){

        //call the get call method from ApiCalls
        ApiCalls apiCalls = new ApiCalls();
        Response response = apiCalls.getMethod("/api/users");

        //convert the response received from get call into a jsonpath object
        JsonPath jsonPath = new JsonPath(response.asString());

        //parse though the response using jsonpath
        System.out.println("Data "+jsonPath.get("data[0].first_name"));
    }
}
