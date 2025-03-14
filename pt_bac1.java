import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LinearEquationSolver {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Giải phương trình bậc nhất");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(new Color(230, 240, 250));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        JTextField aField = new JTextField(10);
        JTextField bField = new JTextField(10);
        JLabel resultLabel = new JLabel("Nghiệm: ");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        JButton solveButton = new JButton("Giải");
        solveButton.setFont(new Font("Arial", Font.BOLD, 14));
        solveButton.setBackground(new Color(100, 180, 100));
        solveButton.setForeground(Color.WHITE);
        
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(aField.getText());
                    double b = Double.parseDouble(bField.getText());
                    
                    if (a == 0) {
                        if (b == 0) {
                            resultLabel.setText("Nghiệm: Vô số nghiệm");
                        } else {
                            resultLabel.setText("Nghiệm: Vô nghiệm");
                        }
                    } else {
                        double x = -b / a;
                        resultLabel.setText("Nghiệm: x = " + x);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Vui lòng nhập số hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        gbc.gridx = 0; gbc.gridy = 0;
        frame.add(new JLabel("Hệ số a: "), gbc);
        gbc.gridx = 1;
        frame.add(aField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        frame.add(new JLabel("Hệ số b: "), gbc);
        gbc.gridx = 1;
        frame.add(bField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        frame.add(solveButton, gbc);

        gbc.gridy = 3;
        frame.add(resultLabel, gbc);
        
        frame.setVisible(true);
    }
}
