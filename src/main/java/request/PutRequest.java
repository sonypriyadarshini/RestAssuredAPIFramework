package request;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;

public class PutRequest {

    public JSONObject formPutRequest(){

        String name = RandomStringUtils.randomAlphabetic(5);
        String job = RandomStringUtils.randomAlphabetic(10);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name",name);
        jsonObject.put("job", job);

        return jsonObject;
    }
}
