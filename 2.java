import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class OddNumberFilter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Nhập mảng và in số lẻ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(new Color(230, 240, 250));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        JTextField arrayField = new JTextField(20);
        JLabel resultLabel = new JLabel("Số lẻ: ");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        JButton processButton = new JButton("Lọc số lẻ");
        processButton.setFont(new Font("Arial", Font.BOLD, 14));
        processButton.setBackground(new Color(100, 180, 100));
        processButton.setForeground(Color.WHITE);
        
        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String input = arrayField.getText();
                    String[] numbers = input.split(",");
                    List<Integer> oddNumbers = new ArrayList<>();
                    
                    for (String num : numbers) {
                        int value = Integer.parseInt(num.trim());
                        if (value % 2 != 0) {
                            oddNumbers.add(value);
                        }
                    }
                    
                    resultLabel.setText("Số lẻ: " + oddNumbers);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Vui lòng nhập các số hợp lệ, ngăn cách bằng dấu phẩy", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(new JLabel("Nhập mảng (cách nhau bằng dấu phẩy): "), gbc);
        gbc.gridx = 1;
        frame.add(arrayField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 2;
        frame.add(processButton, gbc);

        gbc.gridy = 2;
        frame.add(resultLabel, gbc);
        
        frame.setVisible(true);
    }
}
