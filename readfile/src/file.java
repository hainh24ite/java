import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.util.Scanner;

public class file {
    public static void main(String[] args) throws FileNotFoundException {
        String fileintput = "C:\\Users\\Gaming\\Desktop\\input.txt";
        String fileoutput ="C:\\Users\\Gaming\\Desktop\\output.txt";


        try (FileInputStream fis = new FileInputStream(fileintput);
            FileOutputStream fio = new FileOutputStream(fileoutput)) {
            int d;
            while ((d= fis.read()) !=-1) {
                fio.write(d);
            }
            System.out.println("sao chep file thanh cong");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
