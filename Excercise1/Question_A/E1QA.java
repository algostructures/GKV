import java.util.*;
public class E1QA{
  public static void main(String arg[]){
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int discriminate = b*b - 4*a*c;
    if(discriminate < 0)
      System.out.println("No Real Solutions");

    else if(discriminate == 0){
      double root;
      root = -b/(2.0*a);
      System.out.println("Root 1 :"+root+"  Root 2: "+root);
    }

    else{
      double root1, root2;
      root1 = (-b + Math.sqrt(discriminate))/(2.0 * a);
      root2 = (-b - Math.sqrt(discriminate))/(2.0 * a);
      System.out.println("Root 1 :"+root1+"  Root 2: "+root2);
    }
    sc.close();
  }
}
