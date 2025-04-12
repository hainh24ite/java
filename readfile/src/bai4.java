import java.io.*;

public class bai4 {
    public static void main(String[] args) {
        String file = "output.txt";

        // Ghi danh sách số nguyên và chuỗi vào file dạng văn bản
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            int[] numbers = {10, 20, 30, 40, 60};
            String[] texts = {"Hello", "Java", "File", "IO"};

            // Ghi số nguyên
            writer.write("Số nguyên: ");
            for (int n : numbers) {
                writer.write(n + " ");  // Ghi số và cách nhau bởi dấu cách
            }
            writer.newLine();  // Xuống dòng

            // Ghi chuỗi
            writer.write("Chuỗi: ");
            for (String text : texts) {
                writer.write(text + " "); // Ghi chuỗi và cách nhau bởi dấu cách
            }
            writer.newLine();

            System.out.println("Ghi danh sách số và chuỗi vào file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }

        // Đọc dữ liệu từ file
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            System.out.println("Nội dung trong file:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}
