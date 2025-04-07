package aptech.xml;

import java.util.Scanner;

public class Author {
    String nickname,fullname,email,address,birthdays;

    public Author() {
    }

    public Author(String nickname, String fullname, String email, String address, String birthdays) {
        this.nickname = nickname;
        this.fullname = fullname;
        this.email = email;
        this.address = address;
        this.birthdays = birthdays;
    }

    public void input () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nickname");
        nickname = sc.nextLine();
        System.out.println("Enter fullname");
        fullname = sc.nextLine();
        System.out.println("Enter email");
        email = sc.nextLine();
        System.out.println("Enter address");
        address = sc.nextLine();
        System.out.println("Enter dd/mm/yyyy");
        birthdays = sc.nextLine();
    }
    public String toXML() {
        return " <author>\n" +
                "            <nickname>"+nickname+"</nickname>\n" +
                "            <fullname>"+fullname+"</fullname>\n" +
                "            <email>"+email+"</email>\n" +
                "            <address>"+address+"</address>\n" +
                "            <birthday>"+birthdays+"</birthday>\n" +
                "        </author>";
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthdays() {
        return birthdays;
    }

    public void setBirthdays(String birthdays) {
        this.birthdays = birthdays;
    }

    @Override
    public String toString() {
        return "Author{" +
                "nickname='" + nickname + '\'' +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", birthdays='" + birthdays + '\'' +
                '}';
    }
}
