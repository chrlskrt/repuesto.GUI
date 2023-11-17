package FoodOrderingSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderingSystem extends JFrame{
    private JButton btnOrder;
    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private JPanel jpOrder;

    public FoodOrderingSystem() {
        rbNone.setSelected(true);
        JRadioButton[] disc = {rbNone, rb5, rb10, rb15};
        double discounts[] = {0, 0.05, 0.10, 0.15};
        JCheckBox[] foods = {cPizza, cBurger, cFries, cSundae, cSoftDrinks, cTea};
        int price[] = {100,80,65,40,55,50};
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double total = 0;
                double discount = 0;
                int i = 0;
                double Payable = 0;

                for (JCheckBox food: foods){
                    if(food.isSelected()){
                        total += price[i];
                    }

                    i++;
                }

                if (total == 0){
                    JOptionPane.showMessageDialog(null,"No food selected. Please select at least one.");
                    return;
                }

                i = 0;
                for (JRadioButton d: disc){
                    if (d.isSelected()){
                        discount = discounts[i];
                    }

                    i++;
                }

                Payable = total - (total * discount);
                JOptionPane.showMessageDialog(null,"The total price is Php " + Payable);

                for (JCheckBox c: foods){
                    c.setSelected(false);
                }

                for (JRadioButton c: disc){
                    c.setSelected(false);
                }
            }
        });
    }

    public static void main(String[] args) {
        FoodOrderingSystem fos = new FoodOrderingSystem();
        fos.setContentPane(fos.jpOrder);
        fos.setSize(500,500);
        fos.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fos.setTitle("Food Ordering System");
        fos.setVisible(true);
    }
}
