import java.util.Scanner;
public class E2QB{
  public static void main(String arg[]){
    Scanner Sc = new Scanner(System.in);

    System.out.println("Enter the Dimentions of Matrix One");
    int row_1 = Sc.nextInt();
    int col_1 = Sc.nextInt();
    int [][] mat_1 = new int[row_1][col_1];

    System.out.println("Enter the First Matrix");
    for(int i = 0; i < row_1; i++)
      for(int j = 0; j < col_1; j++)
        mat_1[i][j] = Sc.nextInt();

    System.out.println("Enter the dimentions of Matrix two");
    int row_2 = Sc.nextInt();
    int col_2 = Sc.nextInt();
    int [][] mat_2 = new int[row_2][col_2];

    if(col_1 != row_2)
      System.out.println("Sorry Given Dimentions are not applicable");
    else{
      System.out.println("Enter the Second Matrix");
      for(int i = 0; i < row_2; i++)
        for(int j = 0; j < col_2; j++)
          mat_2 [i][j]= Sc.nextInt();

      int [][] mult = new int[row_1][col_2];
      int sum = 0;
      for(int i = 0; i < row_1; i++)
        for(int j = 0; j < col_2; j++){
          for(int k = 0; k < row_2; k++)
            sum += mat_1[i][k] * mat_2[k][j];
            mult[i][j] = sum;
            sum = 0;
        }

      System.out.println("Result : \n");
      for(int i = 0; i < row_1; i++){
        for(int j = 0; j < col_2; j++)
            System.out.print(mult[i][j]+"  ");
        System.out.println();
      }
    }
  }
}
