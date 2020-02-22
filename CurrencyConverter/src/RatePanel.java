// ******************************************************************
// RatePanel.java
//
// Panel for a program that converts different currencies to
// U.S. Dollars
// ******************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RatePanel extends JPanel
{
    private double[] rate; // exchange rates
    private String[] currencyName;
    private JTextField amountInDollar;
    private JComboBox currencyComboBox;
    private JLabel result;
    // ------------------------------------------------------------
// Sets up a panel to convert cost from one of 6 currencies
// into U.S. Dollars. The panel contains a heading, a text
// field for the cost of the item, a combo box for selecting
// the currency, and a label to display the result.
// ------------------------------------------------------------
    public RatePanel ()
    {
        JLabel title = new JLabel ("How much is that in dollars?");
        title.setAlignmentX (Component.CENTER_ALIGNMENT);
        title.setFont (new Font ("Helvetica", Font.BOLD, 20));

// Set up the arrays for the currency conversions
        currencyName = new String[] {"Select the currency..",
                "European Euro", "Canadian Dollar",
                "Japanese Yen", "Australian Dollar",
                "Indian Rupee", "Mexican Peso"};

        rate = new double [] {0.0, 1.2103, 0.7351,
                0.0091, 0.6969,
                0.0222, 0.0880};

        currencyComboBox = new JComboBox(currencyName);
        currencyComboBox.addActionListener(new ComboListener());
        currencyComboBox.setAlignmentX(CENTER_ALIGNMENT);

        amountInDollar = new JTextField("0");
        amountInDollar.addActionListener(new ComboListener());
        amountInDollar.setColumns(5);

        result = new JLabel (" ------------ ");
        result.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(title);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(currencyComboBox);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(amountInDollar);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(result);

        this.setPreferredSize(new Dimension(400, 200));
        this.add(panel);
    }
    // ******************************************************
// Represents an action listener for the combo box.
// ******************************************************
    private class ComboListener implements ActionListener
    {
        // --------------------------------------------------
// Determines which currency has been selected and
// the value in that currency then computes and
// displays the value in U.S. Dollars.
// --------------------------------------------------
        public void actionPerformed (ActionEvent event)
        {
            if (currencyComboBox.getSelectedIndex() == 0){
                result.setText("0");
            } else {
                int index = currencyComboBox.getSelectedIndex();
                try {
                    if (amountInDollar.getText() == "0"){
                        result.setText("1" + currencyName[index] +
                                " = " + rate[index] + " U.S. Dollars");
                    } else {
                        result.setText (amountInDollar.getText() + " " + currencyName[index] +
                                " = " + Float.parseFloat(amountInDollar.getText())*rate[index] + " U.S. Dollars");
                    }
                } catch (NumberFormatException err){
                    JOptionPane.showMessageDialog(null, "Input number only please ..");
                }
            }
        }
    }
    // done 135 minutes
}