import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ReadWrite rw = new ReadWrite();
        String path = "./File.txt";

        ArrayList <String> lineList = null;
        try {
            lineList = rw.readLinesFromFile(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        rw.showList(lineList);
    }
}
