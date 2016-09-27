import java.util.*;
public class E3QB{
  public static void main(String arg[]){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter The Number Of Strings");
    int n = sc.nextInt();
    sc.nextLine();
    String names[] = new String[n];
    for(int i = 0; i < n; i++){
      names[i] = sc.nextLine();
    }

   // libSort(names); // sorting through library functions
    mySort(names); // created whole function to sort
    for(int i = 0; i < n; i++){
      System.out.println(names[i]);
    }
  }

  public static void libSort(String names[]){
    Arrays.sort(names);
  }
  /**
  Using Selection Sort.
  */
  public static void mySort(String names[]){
      for(int i = 0; i < names.length-1; i++){
          String min = names[i];
          int minIndex = i;
          for(int j = i+1; j < names.length; j++){
              if(min.compareToIgnoreCase(names[j]) > 0){
                  min = names[j];
                  minIndex = j;
              }
          }
          String temp = names[i];
          names[i] = names[minIndex];
          names[minIndex] = temp;
      }
  }
}
