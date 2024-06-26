import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display;
    private JButton[] numberButtons;
    private JButton addBtn, subtractBtn, multiplyBtn, divideBtn, clearBtn, equalsBtn;
    private double operand1 = 0;
    private String operator = "";

    public Calculator() {
        setTitle("Peanuts Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        pack(); // Pack the frame to adjust its size to fit components
        setSize(300,300);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        //set the Application Icon (Globally) 
        setIconImage(new ImageIcon(getClass().getResource("/images/peanut.png")).getImage());
    }

    private void initComponents() {
        // Create the display field
        display = new JTextField(10);
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(display.getFont().deriveFont(24f)); // Set font size for the display
        //display.setCursor(new Cursor(Cursor.TEXT_CURSOR)); // Set cursor to TextCursor
        Image cursorImage = new ImageIcon(getClass().getResource("/images/peanut.png")).getImage();
        Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0,0), "CustomCursor");
        display.setCursor(customCursor);

        // Create number buttons
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setPreferredSize(new Dimension(60, 60)); // Set preferred size for number buttons
            numberButtons[i].setFont(numberButtons[i].getFont().deriveFont(20f)); // Set font size for number buttons
            numberButtons[i].addActionListener(this);
        }



        // Create operator buttons
        addBtn = new JButton("+");
        subtractBtn = new JButton("-");
        multiplyBtn = new JButton("*");
        divideBtn = new JButton("/");
        
        //Custom Icon for CE button 
        clearBtn = new JButton("C");
        clearBtn.setIcon(new ImageIcon(getClass().getResource("/images/anyag_r2.jpg")));
        clearBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        clearBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        clearBtn.addActionListener(this);
        //Custom Cursor 
        Image cursorImageClear = new ImageIcon(getClass().getResource("/images/CE.png")).getImage();
        Cursor customCursorC = Toolkit.getDefaultToolkit().createCustomCursor(cursorImageClear, new Point(0,0), "customCursorC");
        clearBtn.setCursor(customCursorC);

        
        equalsBtn = new JButton("=");
        equalsBtn.setIcon(new ImageIcon(getClass().getResource("/images/Anya_E.jpg")));
        equalsBtn.setHorizontalTextPosition(SwingConstants.CENTER);
        equalsBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        equalsBtn.addActionListener(this);
        //Custom Cursor 
        Image cursorImageEquals = new ImageIcon(getClass().getResource("/images/equal.png")).getImage();
        Cursor customCursorE = Toolkit.getDefaultToolkit().createCustomCursor(cursorImageEquals, new Point(0, 0), "customCursorE");
        equalsBtn.setCursor(customCursorE);


        Dimension operatorButtonSize = new Dimension(60, 60); // Size for operator buttons
        addBtn.setPreferredSize(operatorButtonSize);
        subtractBtn.setPreferredSize(operatorButtonSize);
        multiplyBtn.setPreferredSize(operatorButtonSize);
        divideBtn.setPreferredSize(operatorButtonSize);
        clearBtn.setPreferredSize(operatorButtonSize);
        equalsBtn.setPreferredSize(operatorButtonSize);
        addBtn.addActionListener(this);
        subtractBtn.addActionListener(this);
        multiplyBtn.addActionListener(this);
        divideBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        equalsBtn.addActionListener(this);

        // Set layout
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add buttons to the button panel
        for (int i = 7; i <= 9; i++) {
            buttonPanel.add(numberButtons[i]);
        }
        buttonPanel.add(addBtn);

        for (int i = 4; i <= 6; i++) {
            buttonPanel.add(numberButtons[i]);
        }
        buttonPanel.add(subtractBtn);

        for (int i = 1; i <= 3; i++) {
            buttonPanel.add(numberButtons[i]);
        }
        buttonPanel.add(multiplyBtn);

        buttonPanel.add(numberButtons[0]);
        buttonPanel.add(divideBtn);
        buttonPanel.add(clearBtn);
        buttonPanel.add(equalsBtn);

        // Add components to the frame
        getContentPane().setLayout(new BorderLayout());

        //Set background Image
        try {
            ImageIcon backgroundImageIcon = new ImageIcon(getClass().getResource("/images/PSBII.jpg"));
            Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH); // Adjust width and height as needed
            ImageIcon scaledBackgroundImageIcon = new ImageIcon(backgroundImage);
            JLabel backgroundLabel = new JLabel(scaledBackgroundImageIcon);
            setContentPane(backgroundLabel);
        } catch (Exception e) {
            e.printStackTrace();
        }

            // Add display and button panel to the content pane
            getContentPane().setLayout(new BorderLayout());
            getContentPane().add(display, BorderLayout.NORTH);
            getContentPane().add(buttonPanel, BorderLayout.CENTER);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonText = button.getText();
        if (buttonText.equals("C")) {
            display.setText("");
            operand1 = 0;
            operator = "";
        } else if (buttonText.equals("=")) {
            // Perform calculation only if operator is not empty
            if (!operator.isEmpty()) {
                double result = performOperation(operand1, Double.parseDouble(display.getText()), operator);
                display.setText(String.valueOf(result));
                operand1 = 0;
                operator = "";
            }
        } else if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("*") || buttonText.equals("/")) {
            operand1 = Double.parseDouble(display.getText());
            operator = buttonText;
            display.setText("");
        } else {
            display.setText(display.getText() + buttonText);
        }
    }
    

    private double performOperation(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2; 
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 == 0) {
                    JOptionPane.showMessageDialog(this, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                    return 0;
                }
                return operand1 / operand2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Calculator::new);
    }
}


