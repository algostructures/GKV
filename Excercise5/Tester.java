/*Driver Method for expression evaluation*/
import java.io.*;
public class Tester {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        EvaluateExpression e = new EvaluateExpression(reader.readLine());
        System.out.println("Postfix : "+e.toPostfix());
        System.out.println("Value : "+e.evaluate());
    }
}
