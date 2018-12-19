package fileComparatorHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public static BufferedReader readFile(String FilePath) throws IOException {
        File file1 = new File("/Users/sony.priyadarshini/Documents/Sony_Personal_Code/" +
                "RestAssuredFramework/src/main/java/utils/dataProvider/" + FilePath);

        BufferedReader br = new BufferedReader(new FileReader(file1));
        return br;
    }
}
