package commons.base;

import com.google.gson.JsonObject;

import java.util.Map;

public class ApiRequest {
    private HttpVerbs methodType;
    private String baseURL;
    private String path;
    private Map<String, String> header;
    private Map<String, Object> queryParam;
    private Map<String, Object> formParam;
    private String requestBody;
    private JsonObject requestBodyInJson;


    public ApiRequest(RequestBuilder builder) {

        this.methodType = builder.methodType;
        this.baseURL = builder.baseURL;
        this.path = builder.path;
        this.header = builder.header;
        this.queryParam = builder.queryParam;
        this.formParam = builder.formParam;
        this.requestBody = builder.requestBody;
        this.requestBodyInJson = builder.requestBodyInJson;
    }

    public HttpVerbs getMethodType()
    {
        return methodType;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public String getPath() {
        return path;
    }

    public Map<String, String> getHeader() {
        return header;
    }

    public Map<String, Object> getQueryParam() {
        return queryParam;
    }

    public Map<String, Object> getFormParam() {
        return formParam;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public JsonObject getRequestBodyInJson() {
        return requestBodyInJson;
    }


    public static class RequestBuilder {

        HttpVerbs methodType;
        public String baseURL;
        public String path;
        public Map<String, String> header;
        public Map<String, Object> queryParam;
        public Map<String, Object> formParam;
        public String requestBody;
        public JsonObject requestBodyInJson;


        public RequestBuilder setRequestType(HttpVerbs methodType)
        {
            this.methodType = methodType;
            return this;
        }

        public RequestBuilder setBaseURL(String url) {
            baseURL = url;
            return this;
        }

        public RequestBuilder setPath(String path) {
            this.path = path;
            return this;
        }

        public RequestBuilder setHeaders(Map<String, String> header) {
            this.header = header;
            return this;
        }

        public RequestBuilder setQueryParam(Map<String, Object> param) {
            queryParam = param;
            return this;
        }

        public RequestBuilder setRequestBody(String body) {
            requestBody = body;
            return this;
        }

        public RequestBuilder setRequestBody(JsonObject object) {
            requestBodyInJson = object;
            return this;
        }

        public ApiRequest build() {
            ApiRequest request = new ApiRequest(this);
            return request;
        }


    }

}
