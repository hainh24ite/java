package aptech.xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static List<Author> authors = new ArrayList<>();
    static List<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choose = 0;
        do {
            showMenu();
            try {
                choose = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
                continue;
            }
            switch (choose) {
                case 1:
                    inputAuthor();
                    break;
                case 2:
                    inputBook();
                    break;
                case 3:
                    displayBook();
                    break;
                case 4:
                    saveFile();
                    break;
                case 5:
                    try {
                        readFile();
                    } catch (IOException | SAXException | ParserConfigurationException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    System.out.println("Goodbye!!!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng thử lại.");
                    break;
            }
        } while (choose != 6);
    }

    private static void displayBook() {
        if (books.isEmpty()) {
            System.out.println("Không có sách nào!");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private static void readFile() throws IOException, SAXException, ParserConfigurationException {
        File file = new File("library.xml");
        if (!file.exists()) {
            System.out.println("File library.xml không tồn tại!");
            return;
        }

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        LibraryParser libraryParser = new LibraryParser();
        parser.parse(file, libraryParser);

        authors = libraryParser.getAuthorList(); // Đảm bảo LibraryParser có phương thức getAuthorList()
        books = libraryParser.getBookList(); // Đảm bảo LibraryParser có phương thức getBookList()

        displayBook();
    }

    private static void saveFile() {
        try (FileOutputStream fos = new FileOutputStream("library.xml")) {
            StringBuilder authorList = new StringBuilder();
            for (Author author : authors) {
                authorList.append(author.toXML());
            }

            StringBuilder bookList = new StringBuilder();
            for (Book book : books) {
                bookList.append(book.toXML());
            }

            String content = toXML(authorList.toString(), bookList.toString());
            fos.write(content.getBytes("UTF-8"));
            System.out.println("Lưu thành công!");
        } catch (IOException e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Lỗi khi lưu file", e);
        }
    }

    private static String toXML(String authorList, String bookList) {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<library>\n" +
                "    <author-list>\n" +
                "        " + authorList + "\n" +
                "    </author-list>\n" +
                "    <book-list>\n" +
                "        " + bookList + "\n" +
                "    </book-list>\n" +
                "</library>\n";
    }

    private static void inputBook() {
        System.out.print("Nhập số lượng sách: ");
        try {
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                Book book = new Book();
                book.input();
                books.add(book);
            }
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số hợp lệ!");
        }
    }

    private static void inputAuthor() {
        System.out.print("Nhập số lượng tác giả: ");
        try {
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                Author author = new Author();
                author.input();
                authors.add(author);
            }
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số hợp lệ!");
        }
    }

    static void showMenu() {
        System.out.println("========== MENU ==========");
        System.out.println("1. Nhập tác giả");
        System.out.println("2. Nhập sách");
        System.out.println("3. Hiển thị sách");
        System.out.println("4. Lưu vào library.xml");
        System.out.println("5. Đọc từ library.xml");
        System.out.println("6. Thoát");
        System.out.print("Chọn: ");
    }
}
