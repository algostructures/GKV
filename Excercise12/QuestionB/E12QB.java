import java.awt.*;
import java.applet.*;
/*
 * run this using appletviewer
 **/
public class E12QB extends Applet{
    public void paint(Graphics g){
          Color c1=new Color(30,50,110);
          g.setColor(c1);
          g.drawRect(250,250,100,100);
          g.drawOval(100,100,50,50);
          g.drawLine(50,20,10,10);
    }
}
