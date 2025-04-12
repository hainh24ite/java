import java.io.FileNotFoundException;

public class docfile {
    public static void main(String[] args) throws FileNotFoundException {
        String [] filename = {"input.txt" ,"output.txt"};
        for (String file : filename) {
            bai5 thread = new bai5(file);
            thread.start();
        }
    }
}
