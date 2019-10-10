package commons.call;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;

/* actual API calls are made here using RestAssured
*/

public class ApiCalls {
    static Logger log = Logger.getLogger(ApiCalls.class);

    public static Response getMethod(String endpoint){

        //using Requestspecification class
        RequestSpecification requestSpecification = RestAssured.given();
        log.info("===================URL is "+endpoint);
        requestSpecification.contentType("application/json");
        return requestSpecification.get(endpoint).then().log().all().and().extract().response();
    }

    public static Response postMethod(String endpoint, JSONObject json){

        log.info("====================URL is "+endpoint);
        log.info("====================Request is "+json.toString());
        return  given()
                    .header("Content-Type","application/json")
                    .body(json.toJSONString())
                .when().post(endpoint)
                .then().statusCode(201)
                .and().log().all()
                .extract().response();
    }

    public static Response putMethod(String endpoint, JSONObject json){

        log.info("====================URL is "+RestAssured.baseURI+endpoint);
        log.info("====================Request is "+json.toString());
        return  given()
                .header("Content-Type","application/json")
                .body(json.toJSONString())
                .when().put(endpoint)
                .then().statusCode(200)
                .and().log().all()
                .extract().response();
    }
}
