import java.io.*;
import java.util.*;
public class E4QB{
  public static void main(String arg[]) throws IOException{
    BufferedReader reader = new BufferedReader(new FileReader("Sample.txt"));
    int count = 1;
    String currentLine;
    while((currentLine = reader.readLine()) != null){
        System.out.println(count+" "+currentLine);
        count++;
    }
  }
}
