import java.io.*;

public class bai6 {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\Gaming\\Desktop\\test");
        File[] files = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });

        if (files == null || files.length == 0) {
            System.out.println("Không có tệp nào trong thư mục!");
            return;
        }

        File outputFile = new File("output.txt");

        for (File file : files) {
            Thread thread = new FileReaderThread(file, outputFile);
            thread.start();
        }
    }
}

class FileReaderThread extends Thread {
    private final File inputFile;
    private final File outputFile;

    public FileReaderThread(File inputFile, File outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    @Override
    public void run() {
        synchronized (outputFile) { // ghi dữ liệu an toàn giữa các luồng
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                    writer.newLine();
                }

                System.out.println("Hoàn thành đọc file: " + inputFile.getName());

            } catch (IOException e) {
                System.err.println("Lỗi khi xử lý file: " + inputFile.getName());
            }
        }
    }
}
