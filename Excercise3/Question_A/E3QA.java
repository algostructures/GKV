import java.util.*;
public class E3QA{
  public static void main(String arg[]){
    Scanner sc = new Scanner(System.in);
    char[] string = sc.nextLine().toCharArray();
    boolean flag = false;
    int l = 0;
    int r = string.length-1;
    while(l < r){
      if(string[l] == string[r]){
        l++;
        r--;
      }
      else{
        flag = true;
        break;
      }
    }
    if(!flag)
      System.out.println("Palindrome");
    else
      System.out.println("Not Palindrome");
    /*
    shortcut but not as efficient as before
    String string = sc.nextLine();
    if(string.equals(new StringBuffer(string).reverse().toString()))
        System.out.println("Palindrome");
    else
        System.out.println("Not Palindrome");
    */
  }
}
