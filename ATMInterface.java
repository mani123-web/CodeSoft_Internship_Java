import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMInterface {

    private static double balance = 1000.00; // Starting balance

    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("ATM Interface");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create components
        JButton checkBalanceButton = new JButton("Check Balance");
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JTextArea displayArea = new JTextArea();
        displayArea.setBounds(20, 20, 240, 80);
        displayArea.setEditable(false);
        
        checkBalanceButton.setBounds(20, 110, 120, 30);
        depositButton.setBounds(150, 110, 120, 30);
        withdrawButton.setBounds(85, 150, 120, 30);

        // Add components to frame
        frame.add(displayArea);
        frame.add(checkBalanceButton);
        frame.add(depositButton);
        frame.add(withdrawButton);

        // Button action listeners
        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText("Current balance: $" + balance);
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountStr = JOptionPane.showInputDialog("Enter deposit amount:");
                try {
                    double amount = Double.parseDouble(amountStr);
                    if (amount > 0) {
                        balance += amount;
                        displayArea.setText("Deposited: $" + amount);
                    } else {
                        displayArea.setText("Invalid deposit amount.");
                    }
                } catch (NumberFormatException ex) {
                    displayArea.setText("Invalid input.");
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountStr = JOptionPane.showInputDialog("Enter withdrawal amount:");
                try {
                    double amount = Double.parseDouble(amountStr);
                    if (amount > 0 && amount <= balance) {
                        balance -= amount;
                        displayArea.setText("Withdrew: $" + amount);
                    } else if (amount > balance) {
                        displayArea.setText("Insufficient funds.");
                    } else {
                        displayArea.setText("Invalid withdrawal amount.");
                    }
                } catch (NumberFormatException ex) {
                    displayArea.setText("Invalid input.");
                }
            }
        });

        // Display the frame
        frame.setVisible(true);
    }
}