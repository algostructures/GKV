import java.io.*;
import java.util.*;
public class E4QC{
  public static void main(String arg[]) throws IOException{
    BufferedReader reader = new BufferedReader(new FileReader("Sample.txt"));
    int lines = 0;
    int chars = 0;
    int words = 0;
    String currentLine;
    while((currentLine = reader.readLine()) != null){
        lines++;
        StringTokenizer tokens = new StringTokenizer(currentLine, "., ");
        //where dot(.), comma(,), and space are delimeters.
        while(tokens.hasMoreTokens()){
            chars += tokens.nextToken().length();
            words++;
        }
    }
    System.out.println("Line : "+ lines+"\n"+"Words : "+words+"\n"+"Characters : "+chars);
  }
}
