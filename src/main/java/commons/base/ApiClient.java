package commons.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ApiClient {
    public Response performRequest(ApiRequest request) {
        RequestSpecification specification;
        RequestSpecBuilder builder = new RequestSpecBuilder();

        if (request.getQueryParam() != null) {
            builder.addQueryParams(request.getQueryParam());
        }

        if (request.getHeader() != null) {
            builder.addHeaders(request.getHeader());
        }

        if (request.getFormParam() != null) {
            builder.addFormParams(request.getFormParam());
        }

        if (request.getRequestBody() != null) {
            builder.setBody(request.getRequestBody());
        }

        if (request.getBaseURL().contains("http")) {
            builder.setBaseUri(request.getBaseURL());
        }

        if (request.getPath() != null) {
            builder.setBasePath(request.getPath());
        }

        specification = builder.build().log().all();

        return executeRequest(specification,request.getMethodType());

    }


    public Response executeRequest(RequestSpecification specification, HttpVerbs requestType) {
        Response response = null;


        switch (requestType) {
            case GET:
                response = RestAssured.given(specification).get().then().log().all().and().extract().response();
                break;

            case PUT:
                response = RestAssured.given(specification).put();
                break;

            case POST:
                response = RestAssured.given(specification).post().then().log().all().and().extract().response();
                break;

            case PATCH:
                response = RestAssured.given(specification).patch();
                break;

            case DELETE:
                response = RestAssured.given(specification).delete();
                ValidatableResponse response1 = (ValidatableResponse) RestAssured.given(specification).delete();
                break;

            default:
                System.out.println("Please enter a valid request type");

        }

        return response;
    }
}
