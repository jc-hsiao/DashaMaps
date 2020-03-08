import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class MainApp {

    public static void main(String[] args) {
        DashaMap map1 = new DashaMapOne();
        DashaMap map2 = new DashaMapTwo();
        DashaMap map3 = new DashaMapThree();
        String filePath = "word-list.txt";

        readFile(filePath,map1);
        readFile(filePath,map2);
        readFile(filePath,map3);


    }

    public static void readFile(String fileName, DashaMap map){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                String[] data = sCurrentLine.split(" ");
                map.set(data[0], Integer.valueOf(data[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
