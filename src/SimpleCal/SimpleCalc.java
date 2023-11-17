package SimpleCal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class SimpleCalc extends JFrame {
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JTextField tfNumber2;
    private JButton btnCompute;
    private JPanel jpcalcu;
    private JLabel lblResult;

    public SimpleCalc() {
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num1 = parseInt(tfNumber1.getText());
                int num2 = parseInt(tfNumber2.getText());
                String op = (String) cbOperations.getSelectedItem();
                int result = 0;

                switch (op){
                    case "+":
                        result = num1 + num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                }

                lblResult.setText(String.valueOf(result));
            }
        });
    }

    public static void main(String[] args) {
        SimpleCalc calc = new SimpleCalc();
        calc.setContentPane(calc.jpcalcu);
        calc.setSize(800,400);
        calc.setDefaultCloseOperation(EXIT_ON_CLOSE);
        calc.setTitle("Simple Calculator");
        calc.setVisible(true);
    }
}
