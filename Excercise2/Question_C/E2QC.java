import java.util.*;
import java.io.*;
public class E2QC{
  public static void main(String arg[]) throws IOException{
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokens = new StringTokenizer(reader.readLine());
    int sum = 0;
    int temp = 0;
    while(tokens.hasMoreTokens()){
      temp = Integer.parseInt(tokens.nextToken());
      System.out.print(temp+" ");
      sum+= temp;
    }
    System.out.print("\n"+sum);
  }
}
