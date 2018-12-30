<h2>API automation framework using RestAssured.</h2>

**Test:**
1. testApi package has the test methods for get, put and post
2. it contains composing the request and parsing through the response
    
**Composing request/payload for put/post:**
1. `org.json.simple.JSONObject` is used to form the request
    
**Making the WebService/Api call to the http verbs get,put,post:**
1. ApiCalls class is written to take care of this
2. `io.restassured.RestAssured` is used to make the API calls
3. BDD approach is used while writing the methods
4. all the methods return the corresponding response `io.restassured.response.Response`  
    
**Fetching the response:**
1. `io.restassured.path.json.JsonPath` JsonPath is used to convert the Response to a java object
2.  JsonPath is used to parse through the response

**File Comparator** 
1. 