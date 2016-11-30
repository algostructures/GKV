import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
;

public class E10 extends JFrame {
    private JPanel panel;
    private JTextField textfield1;
    private JTextField textfield11;
    private JLabel ansLabel;

    public E10() {
        panel = new JPanel(new FlowLayout());
        this.getContentPane().add(panel);
        addTextField();
        addButtons();
        addAnswerLabel();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Exercise10");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    private void addTextField() {
        JLabel valueLabel1 = new JLabel("Enter First value");
        panel.add(valueLabel1);
        textfield1 = new JTextField();
        textfield1.setColumns(9);
        panel.add(textfield1);

        JLabel valueLabel2 = new JLabel("Enter Second value");
        panel.add(valueLabel2);
        textfield11 = new JTextField();
        textfield11.setColumns(9);
        panel.add(textfield11);
    }

    private void addButtons() {
        JButton divButton = new JButton("Devide");
        panel.add(divButton);
        addDivListener(divButton);
    }



    private void addAnswerLabel() {
        ansLabel = new JLabel();
        panel.add(ansLabel);
    }


    private void addDivListener(JButton button) {
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                try{
                    ansLabel.setText(String.valueOf(Double.parseDouble(textfield1.getText().trim()) /Double.parseDouble(textfield11.getText().trim())));
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(panel, ex.toString());
                }
                catch(ArithmeticException ex){
                    JOptionPane.showMessageDialog(panel, ex.toString());
                }
            }
        });
    }

    public static void main(String[] args) {
        new E10();
    }
}
