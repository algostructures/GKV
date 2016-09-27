import java.util.*;
public class E1QB{
	public static void main(String arg[]){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println("Iterative Fibonacci :"+iterativeFib(n));
    System.out.println("Recursive Fibonacci :"+recursiveFib(n));
    sc.close();
  }
	private static int iterativeFib(int n){
		if(n == 1 || n == 2)
			return 1;
		else{
			int first = 1;
			int second = 1;
			int result = 0;;
			while(n > 2){
				result = first + second;
				first = second;
				second = result;
				n--;
			}
			return result;
		}
	}
	private static int recursiveFib(int n){
		if(n == 1 || n == 2)
			return 1;
		return recursiveFib(n-1)+recursiveFib(n-2);
	}
}
