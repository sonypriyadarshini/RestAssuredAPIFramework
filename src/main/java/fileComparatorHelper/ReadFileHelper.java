package fileComparatorHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileHelper {

    public static BufferedReader readFile(String FilePath) throws IOException {
        File file1 = new File(FileComparatorConstant.BASE_FILEPATH+FilePath);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
        return bufferedReader;
    }

    public int getLinesCount(String fileName) throws IOException {
        BufferedReader bufferedReader= ReadFileHelper.readFile(fileName);
        int file1LineCount = 0;
        while (bufferedReader.readLine() != null) file1LineCount++;
        System.out.println("file1LineCount: "+file1LineCount);
        return file1LineCount;
    }
}
