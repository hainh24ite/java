import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LoginAndRe service = new LoginAndRe();

        while (true) {
            System.out.println("\n1. Đăng ký");
            System.out.println("2. Đăng nhập");
            System.out.println("3. Xuất XML");
            System.out.println("4. Nhập XML");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int choice = sc.nextInt();
            sc.nextLine(); // bỏ dòng

            switch (choice) {
                case 1 -> {
                    System.out.print("ten: ");
                    String ten = sc.nextLine();
                    System.out.println("ten dang nhap: ");
                    String user = sc.nextLine();
                    System.out.print("mat khau: ");
                    String pass = sc.nextLine();
                    System.out.println("tuoi: ");
                    int tuoi= sc.nextInt();
                    service.Rei(user, tuoi,ten,pass);
                }
                case 2 -> {
                    System.out.print("ten dng nhap: ");
                    String user = sc.nextLine();
                    System.out.print("mat khau: ");
                    String pass = sc.nextLine();
                    service.Login(user, pass);
                }
                case 3 -> {
                    try {
                        XML.exportXML(service.getAllUsers(), "users.xml");
                        System.out.println("Đã xuất ra users.xml");
                    } catch (Exception e) {
                        System.out.println("Lỗi xuất XML: " + e.getMessage());
                    }
                }
                case 4 -> {
                    try {
                        List<User> imported = XML.importXML("users.xml");
                        System.out.println("Danh sách người dùng từ XML:");
                        imported.forEach(System.out::println);
                    } catch (Exception e) {
                        System.out.println("Lỗi nhập XML: " + e.getMessage());
                    }
                }
                case 0 -> {
                    System.out.println("Tạm biệt!");
                    return;
                }
            }
        }
    }
}
