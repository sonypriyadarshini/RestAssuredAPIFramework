package fileComparatorHelper;

import io.restassured.path.json.JsonPath;

public class JsonComparator {
    public static boolean comparator(JsonPath jsonPathA, JsonPath jsonPathB){

        boolean b;
        b= jsonPathA.get("data.first_name").equals(jsonPathB.get("data.first_name"));
        return b;
    }
}
