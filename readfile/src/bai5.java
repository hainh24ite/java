import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.PublicKey;

public class bai5 extends Thread {
    private String filename;
    public bai5(String filename) {
        this.filename=filename;
    }
    @Override
    public void run () {
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            System.out.println("noi dung file "+filename);
            String line;
            while ((line = reader.readLine()) !=null) {
                System.out.println(line);
            }
            System.out.println("----------------");

        } catch (Exception e) {
            System.out.println("loi khi doc file");
        }
    }
}

