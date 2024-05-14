import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    private JButton N1, N2, N3, N4, N5, N6, N7, N8, N9, N0, addBtn, subsBtn, multiBtn, divBtn, percentage, power;
    private JTextField display;

    public Calculator() {
        setTitle("AI Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents(); // Initialize components
        setVisible(true);
    }

    public void initComponents() {
        setLayout(new GridLayout(0, 1));

        // Initialize buttons and text field
        N1 = new JButton("1");
        N2 = new JButton("2");
        N3 = new JButton("3");
        N4 = new JButton("4");
        N5 = new JButton("5");
        N6 = new JButton("6");
        N7 = new JButton("7");
        N8 = new JButton("8");
        N9 = new JButton("9");
        N0 = new JButton("0");

        addBtn = new JButton("+");
        subsBtn = new JButton("-");
        multiBtn = new JButton("*");
        divBtn = new JButton("/");
        percentage = new JButton("%");
        power = new JButton("^");

        display = new JTextField();

        // Add action listeners
        N1.addActionListener(this);
        N2.addActionListener(this);
        N3.addActionListener(this);
        N4.addActionListener(this);
        N5.addActionListener(this);
        N6.addActionListener(this);
        N7.addActionListener(this);
        N8.addActionListener(this);
        N9.addActionListener(this);
        N0.addActionListener(this);
        addBtn.addActionListener(this);
        subsBtn.addActionListener(this);
        multiBtn.addActionListener(this);
        divBtn.addActionListener(this);
        percentage.addActionListener(this);
        power.addActionListener(this);

        // Add components to the frame
        add(N1);
        add(N2);
        add(N3);
        add(N4);
        add(N5);
        add(N6);
        add(N7);
        add(N8);
        add(N9);
        add(N0);
        add(addBtn);
        add(subsBtn);
        add(multiBtn);
        add(divBtn);
        add(percentage);
        add(power);
        add(display);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle action events here
        if (e.getSource() == N1) {
            // Handle action for button N1
        } else if (e.getSource() == N2) {
            // Handle action for button N2
        } else if (e.getSource() == N3) {
            // Handle action for button N3
        }
        // Add more conditions for other buttons
    }

    public static void main(String[] args) {
        new Calculator();
    }
}

