//all application logic could be put here
public class Calculator{
  String s;
  final double PI = 3.1415;
	Calculator(String s){
    this.s = s;
	}

  //This method should be called in condition of only one arguement
	public String CalculateCircleArea(){
    int redi = Integer.parseInt(s.trim());
    return new String(""+PI*redi*redi);
	}

  //This method should be called in condition of onlyone arguement
  public String CalculateCircleCircum(){
    int redi = Integer.parseInt(s.trim());
    return new String(""+PI*2*redi);
  }

  public String[] CommaSeparator(){
    String[] list = s.split(",");
    return list;
  }
  //This method should be called in condition of only two arguement
  public String RectangleArea(){
    String sides[] = CommaSeparator();
    int side1 = Integer.parseInt(sides[0].trim());
    int side2 = Integer.parseInt(sides[1].trim());
    return new String (""+side1 * side2);
  }
}
