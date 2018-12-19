package fileComparatorHelper;

import io.restassured.mapper.ObjectMapper;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonComparator {
    public static boolean comparator(JsonPath jsonPathA, JsonPath jsonPathB){

        boolean b;
        b= jsonPathA.get("data.first_name").equals(jsonPathB.get("data.first_name"));
        return b;
    }
}
