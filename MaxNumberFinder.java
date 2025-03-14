
package maxnumberfinder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MaxNumberFinder extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;

    public MaxNumberFinder() {
        setTitle("Tìm số lớn nhất");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel promptLabel = new JLabel("Nhập các số, cách nhau bởi dấu phẩy:");
        add(promptLabel);

        inputField = new JTextField(20);
        add(inputField);

        JButton findButton = new JButton("Tìm số lớn nhất");
        add(findButton);

        resultLabel = new JLabel("Kết quả sẽ hiển thị ở đây");
        add(resultLabel);

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findMaxNumber();
            }
        });
    }

    private void findMaxNumber() {
        try {
            String input = inputField.getText();
            String[] parts = input.split(",");
            int[] numbers = Arrays.stream(parts)
                                  .mapToInt(Integer::parseInt)
                                  .toArray();
            int max = Arrays.stream(numbers).max().orElseThrow();
            resultLabel.setText("Số lớn nhất: " + max);
        } catch (Exception ex) {
            resultLabel.setText("Lỗi: Hãy nhập đúng định dạng!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MaxNumberFinder().setVisible(true);
        });
    }
}


