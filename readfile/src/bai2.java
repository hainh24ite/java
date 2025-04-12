import java.io.*;

public class bai2 {
    public static void main(String[] args) {
        System.out.println("Nhập nội dung cần ghi vào file (nhập 'exit' để kết thúc):");

        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Gaming\\Desktop\\output.txt",true))
        ) {
            String line;
            while ((line = reader.readLine()).equalsIgnoreCase("thoat")) {
                writer.write(line);
                writer.newLine();
                writer.flush();// ghi vao file luon
            }
            System.out.println("Dữ liệu đã được ghi vào file thành công!");

        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu: " + e.getMessage());
        }
    }
}
