package LeapYearChecker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class  LeapYearChecker extends JFrame{
    private JTextField tfYear;
    private JButton btnCheckYear;
    private JPanel jpLeap;

    public LeapYearChecker() {
        btnCheckYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = tfYear.getText();
                int year = 0;

                try {
                    year = parseInt(tfYear.getText());

                    if (year < 0 || year == 0){
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException m){
                    input = JOptionPane.showInputDialog("Please input a valid year");
                    tfYear.setText(input);
                    return;
                }

                if ((year % 4 == 0 && year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)){
                    JOptionPane.showMessageDialog(null,"Leap year");
                } else {
                    JOptionPane.showMessageDialog(null, "Not a leap year");
                }

                tfYear.setText("");

            }
        });
    }

    public static void main(String[] args) {
        LeapYearChecker lp = new LeapYearChecker();
        lp.setContentPane(lp.jpLeap);
        lp.setSize(500,500);
        lp.setDefaultCloseOperation(EXIT_ON_CLOSE);
        lp.setTitle("Leap Year Checker");
        lp.setVisible(true);
    }
}
