/*
Input Format : Enter as much as text you want but last line should only contain -1
my name is xyz. I love Programming.
xyz is a good person.
-1
*/
import java.io.*;
import java.util.*;
public class Main{
  public static void main(String arg[]) throws IOException{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> frequencyTable = new HashMap<String, Integer>();
    while(true){
        String currentLine = reader.readLine();
        if(currentLine.equals("-1"))
            break;
        //Read : http://stackoverflow.com/questions/9446704/using-multiple-delimiters-with-stringtokenizer
        StringTokenizer tokens = new StringTokenizer(currentLine," .,");
        while(tokens.hasMoreTokens()){
            String currentWord = tokens.nextToken();
            if(frequencyTable.containsKey(currentWord.toLowerCase())){
                frequencyTable.put(currentWord.toLowerCase(), frequencyTable.get(currentWord.toLowerCase())+1);
            }
            else{
                frequencyTable.put(currentWord.toLowerCase(), 1);
            }
        }
    }
    for(String word : frequencyTable.keySet()){
        System.out.println(word+" : "+frequencyTable.get(word));
    }
  }
}
