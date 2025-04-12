import java.io.*;

public class bai7 {
    public static void main(String[] args) {
        File folder = new File("C:\\\\Users\\\\Gaming\\\\Desktop\\\\test");
        File[] files = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".txt");
            }
        });

        if (files == null || files.length == 0) {
            System.out.println("Không có file nào trong thư mục!");
            return;
        }

        String keyword = "Java";

        for (File file : files) {
            Thread thread = new KeywordSearchThread(file, keyword);
            thread.start();
        }
    }
}

class KeywordSearchThread extends Thread {
    private final File file;
    private final String keyword;

    public KeywordSearchThread(File file, String keyword) {
        this.file = file;
        this.keyword = keyword;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int count = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(keyword)) {
                    count++;
                }
            }
            System.out.println("Từ khóa '" + keyword + "' xuất hiện " + count + " lần trong file: " + file.getName());
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file: " + file.getName());
        }
    }
}
