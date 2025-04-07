package aptech.xml;

import java.util.Scanner;

public class Book {
    String title,nickname,nxb,desciption;
    float price;

    public Book() {
    }

    public Book(String title, String nickname, String nxb, String desciption, float price) {
        this.title = title;
        this.nickname = nickname;
        this.nxb = nxb;
        this.desciption = desciption;
        this.price = price;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter title");
        title = sc.nextLine();
        System.out.println("enter nickname");
        nickname = sc.nextLine();
        System.out.println("enter nxb");
        nxb=sc.nextLine();
        System.out.println("enter desciption");
        desciption = sc.nextLine();
        System.out.println("enter price");
        price = Float.parseFloat(sc.nextLine());
    }
    public String toXML() {
        return "<book>\n" +
                "            <title>"+title+"</title>\n" +
                "            <nickname>"+nickname+"</nickname>\n" +
                "            <price>"+price+"</price>\n" +
                "            <nxb>"+nxb+"</nxb>\n" +
                "            <desciption>"+desciption+"</desciption>\n" +
                "        </book>\n";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", nickname='" + nickname + '\'' +
                ", nxb='" + nxb + '\'' +
                ", desciption='" + desciption + '\'' +
                ", price=" + price +
                '}';
    }

}
