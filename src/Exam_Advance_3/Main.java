package Exam_Advance_3;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> parentQueue = new LinkedList<>();

        int choice = 0;

        while (choice != 3) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************");
            System.out.println("1. Nhập tên phụ huynh nộp hồ sơ");
            System.out.println("2. Phụ huynh tiếp theo");
            System.out.println("3. Thoát");
            System.out.print("Chọn một lựa chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập tên phụ huynh: ");
                    String parentName = scanner.nextLine();
                    parentQueue.add(parentName);
                    break;
                case 2:
                    if (!parentQueue.isEmpty()) {
                        String nextParent = parentQueue.poll();
                        System.out.println("Phụ huynh đầu tiên trong danh sách: " + nextParent);
                    } else {
                        System.out.println("Danh sách phụ huynh rỗng.");
                    }
                    break;
                case 3:
                    System.out.println("Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }

        scanner.close();
    }
}
