import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class bai3doctufile {
    public static void main(String[] args) {
        String file = "C:\\Users\\Gaming\\Desktop\\input.txt";

        try (BufferedReader read = new BufferedReader(new FileReader(file))) {
            int cout=0;
            while (read.readLine() !=null) {
                cout++;
            }
            System.out.println("so dong trong file la "+cout);
        } catch (Exception e) {
            System.out.println("loi khi doc file " +e.getMessage());
        }
    }
}
