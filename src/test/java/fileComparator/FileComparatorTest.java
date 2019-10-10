package fileComparator;

/*upload 2 files with list of APIs from local.
read each line- line1 from file1, line2 from file2,
make the api calls and compare the json response for each api.
show success if the result matches, else show failed
*/

import commons.call.ApiCalls;
import fileComparatorHelper.FileComparatorConstant;
import fileComparatorHelper.JsonComparator;
import fileComparatorHelper.ReadFileHelper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.BufferedReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class FileComparatorTest {
    static Logger log = Logger.getLogger(FileComparatorTest.class);
    ReadFileHelper readFileHelper=new ReadFileHelper();
    String FileName1,FileName2;

    @BeforeClass
    public void beforeTest() {
        FileName1="ApiData1.csv";
        FileName2="ApiData2.csv";
    }

    // Method 1:
    // Read 1st api from File1, Read 1st api from File2
    // Compare the response and store in a map
    // Repeat step 1 and 2 for all apis
    // Iterate through the Map and print the result

    @Test
    public void compareApiMethod1Test() throws IOException {
        int file1LinesCount= readFileHelper.getLinesCount(FileName1);
        BufferedReader bufferedReader1= ReadFileHelper.readFile(FileName1);
        BufferedReader bufferedReader2= ReadFileHelper.readFile(FileName2);

        LinkedHashMap<String,Boolean> linkedHashMap=new LinkedHashMap<>();

        int lineNum=0;
        String line1,line2;
        while(lineNum!=file1LinesCount){

            line1=bufferedReader1.readLine();
            line2=bufferedReader2.readLine();

            log.info("Read line from File 1 ======== "+line1);
            log.info("Read line from File 2 ======== "+line2);

            Response response1 = ApiCalls.getMethod(line1);
            Response response2 = ApiCalls.getMethod(line2);
            linkedHashMap.put(line1,response1.asString().equals(response2.asString()));
//            System.out.println(response1.asString().equals(response2.asString()));

//            jsonPath1 = new JsonPath(response1.asString());
//            jsonPath2 = new JsonPath(response2.asString());
//            if(JsonComparator.comparator(jsonPath1,jsonPath2))
//                System.out.println("true!!!");

            lineNum++;
        }

        for(Map.Entry<String,Boolean> entry:linkedHashMap.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }

    // Method 2:
    // Read apis of file1 and file2 and store in 2 different arrays,
    // Hit the apis by iterating through the arrays and store the compared response in a map
    // Iterate through the Map and print the result

    @Test(enabled = false)
    public void compareApiMethod2Test() throws IOException {

        ArrayList<String> lines1 = new ArrayList<>(Files.readAllLines
                (Paths.get(FileComparatorConstant.FILEPATH_APIDATA+FileName1)));
        ArrayList<String> lines2 = new ArrayList<>(Files.readAllLines
                (Paths.get(FileComparatorConstant.FILEPATH_APIDATA+FileName2)));

        LinkedHashMap<String,Boolean> linkedHashMap=new LinkedHashMap<>();
        for(int i=0;i<lines1.size();i++){
            Response response1 = ApiCalls.getMethod(lines1.get(i));
            Response response2 = ApiCalls.getMethod(lines2.get(i));
            linkedHashMap.put(lines1.get(i),response1.asString().equals(response2.asString()));
        }
        for(Map.Entry<String,Boolean> entry:linkedHashMap.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}
