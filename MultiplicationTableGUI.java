import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiplicationTableGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField numberField;
    private JTextArea resultArea;

    public MultiplicationTableGUI() {
        setTitle("Multiplication Table Generator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Enter a number:");
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        numberField = new JTextField();
        mainPanel.add(numberField, BorderLayout.WEST);

        JButton generateButton = new JButton("Generate Table");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateTable();
            }
        });
        mainPanel.add(generateButton, BorderLayout.CENTER);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void generateTable() {
        try {
            int number = Integer.parseInt(numberField.getText());
            StringBuilder table = new StringBuilder();

            for (int i = 1; i <= 10; i++) {
                int result = number * i;
                table.append(number).append(" x ").append(i).append(" = ").append(result).append("\n");
            }

            resultArea.setText(table.toString());
        } catch (NumberFormatException ex) {
            resultArea.setText("Invalid input. Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MultiplicationTableGUI multiplicationTableGUI = new MultiplicationTableGUI();
                multiplicationTableGUI.setVisible(true);
            }
        });
    }
}

