import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
public class E6QB extends Applet implements ActionListener
{
    TextField number,result;
    Button bt;
    public E6QB()
    {
        number = new TextField(15);
        result = new TextField(15);
        result.setEditable(false);
        bt = new Button("Compute");
        bt.addActionListener(this);

        add(new Label("Enter First Number"));
        add(number);
        add(new Label("Factorial"));
        add(result);
        add(bt);

    }
    public void actionPerformed(ActionEvent e)
    {
        String str1 = number.getText();
        Integer fn = Integer.parseInt(str1);
        result.setText(""+(fact(fn)));
    }
    private int fact(int fn) {
        int result = 1;
        for(int i = 1; i <= fn; i++)
            result *= i;
        return result;
    }
}
