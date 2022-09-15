import javax.print.DocFlavor;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadWrite {

    CheckData chd = new CheckData();
    public ArrayList<String> readLinesFromFile (String path) throws FileNotFoundException {

        ArrayList <String> linesList = new ArrayList<String>();
        File f = new File(path);
        Scanner sc = new Scanner(f);


            while(sc.hasNextLine()){
            String s = sc.nextLine();

            linesList.add(s);
            }

        return linesList;
    }

    public void showList (ArrayList linesList){

        linesList.forEach((l)->{

            System.out.println((String) l + ": " + chd.tidyLines((String)l));
            /*if(chd.isNumeric((String) l)) {
                System.out.println(chd.operateNumbers((String)l));
            }
            if(chd.isString((String) l)) {
                System.out.println(chd.concactString((String)l));
            }*/
        });

    }
}
