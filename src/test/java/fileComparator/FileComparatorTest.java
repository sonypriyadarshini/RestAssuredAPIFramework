package fileComparator;

/*upload 2 files with list of APIs from local.
read each line- line1 from file1, line2 from file2,
make the api calls and compare the json response for each api.
show success if the result matches, else show failed
*/

import commons.call.ApiCalls;
import fileComparatorHelper.JsonComparator;
import fileComparatorHelper.ReadFile;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.BufferedReader;

import java.io.IOException;

public class FileComparatorTest {
    static Logger log = Logger.getLogger(FileComparatorTest.class);
    static JsonPath jsonPath1, jsonPath2;


    @BeforeClass
    public void beforeTest() throws IOException {

    }

    @Test
    public void compareTest() throws IOException {

        BufferedReader br1=ReadFile.readFile("ApiFile1.txt");
        BufferedReader br2=ReadFile.readFile("ApiFile2.txt");
        int lineNum=0;
        String line1,line2;
        while(lineNum!=2){
            line1=br1.readLine();
            log.info("read line 1 ======== "+line1);
            line2=br2.readLine();
            log.info("read line 2 ======== "+line1);
            Response response1 = ApiCalls.getMethod(line1);
            jsonPath1 = new JsonPath(response1.asString());
            log.info("Data "+jsonPath1.get("data.first_name"));

            Response response2 = ApiCalls.getMethod(line2);
            jsonPath2 = new JsonPath(response2.asString());
            log.info("Data "+jsonPath2.get("data.first_name"));

            if(JsonComparator.comparator(jsonPath1,jsonPath2))
                System.out.println("true!!!");
            lineNum++;
        }

    }
}
