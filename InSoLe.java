import java.util.Scanner;

public class InSoLe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = scanner.nextInt(); // Số lượng phần tử trong mảng
        
        int[] arr = new int[n];
        
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }
        
        System.out.println("Các số lẻ trong mảng là:");
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {  // Nếu số không chia hết cho 2 => số lẻ
                System.out.print(arr[i] + " ");
            }
        }
        
        scanner.close();
    }
}
