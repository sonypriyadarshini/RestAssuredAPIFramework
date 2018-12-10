package commons.call;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

/* actual API calls are made here using RestAssured
*/

public class ApiCalls {
    Logger log = Logger.getLogger(ApiCalls.class);


    public Response getMethod(String endpoint){

        RestAssured.baseURI="https://reqres.in/";
        log.info("URL is "+RestAssured.baseURI+endpoint);
        return  given().contentType("application/json")
                .when().get(endpoint)
                .then().statusCode(200)
                .and().log().all()
                .extract().response();
    }

    public Response postMethod(String endpoint, JSONObject json){

        RestAssured.baseURI="https://reqres.in/";
        log.info("URL is "+RestAssured.baseURI+endpoint);
        log.info("Request is "+json.toString());
        return  given()
                    .header("Content-Type","application/json")
                    .body(json.toJSONString())
                .when().post(endpoint)
                .then().statusCode(201)
                .and().log().all()
                .extract().response();
    }

    public Response putMethod(String endpoint, JSONObject json){

        RestAssured.baseURI="https://reqres.in/";
        log.info("URL is "+RestAssured.baseURI+endpoint);
        log.info("Request is "+json.toString());
        return  given()
                .header("Content-Type","application/json")
                .body(json.toJSONString())
                .when().put(endpoint)
                .then().statusCode(200)
                .and().log().all()
                .extract().response();
    }
}
