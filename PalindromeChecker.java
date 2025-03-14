import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Kiemtramotsocophaisnt extends JFrame {
    private JTextField inputField;
    private JButton checkButton;
    private JLabel resultLabel;
    
    // Constructor có tên giống lớp
    public Kiemtramotsocophaisnt() {
        setTitle("Kiểm Tra Số Nguyên Tố");
        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Căn giữa cửa sổ
        
        // Khởi tạo thành phần giao diện
        inputField = new JTextField(10);
        checkButton = new JButton("Kiểm tra");
        resultLabel = new JLabel("Nhập số và bấm 'Kiểm tra'.");
        
        // Xử lý sự kiện khi bấm nút
        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkPrime();
            }
        });
        
        // Tạo panel chứa input và nút
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Số:"));
        inputPanel.add(inputField);
        inputPanel.add(checkButton);
        
        // Thêm panel và label kết quả vào JFrame
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(resultLabel, BorderLayout.CENTER);
    }
    
    // Phương thức kiểm tra số nguyên tố
    private void checkPrime() {
        try {
            int number = Integer.parseInt(inputField.getText());
            if (number < 2) {
                resultLabel.setText(number + " không phải là số nguyên tố.");
                return;
            }
            boolean isPrime = true;
            // Kiểm tra từ 2 đến căn bậc hai của số
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                resultLabel.setText(number + " là số nguyên tố.");
            } else {
                resultLabel.setText(number + " không phải là số nguyên tố.");
            }
        } catch (NumberFormatException ex) {
            resultLabel.setText("Dữ liệu nhập không hợp lệ. Vui lòng nhập số nguyên.");
        }
    }
    
    public static void main(String[] args) {
        // Khởi chạy giao diện người dùng
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Kiemtramotsocophaisnt().setVisible(true);
            }
        });
    }
}
