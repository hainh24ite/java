package aptech.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class LibraryParser extends DefaultHandler {
    Author author = null;
    Book book = null;
    List<Author> authorlist = new ArrayList<>();
    List<Book> booklist = new ArrayList<>();
    boolean isAuthor= false;
    boolean isNickname=false;
    boolean isFullname=false;
    boolean isAdress=false;
    boolean isBirthday=false;
    boolean isemail=false;


    boolean isBook=false;
    boolean isTitle=false;
    boolean isNickname2=false;
    boolean isNxb= false;
    boolean isDes= false;
    boolean isPrice;
    boolean isdesciption=false;


    // đọc tất cả dữ liệu trong thẻ
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        // đọc xong cái thẻ mở open tag.
        if(qName.equalsIgnoreCase("author")) {
            isAuthor = true;
            author = new Author();
        }
        if(isAuthor) {
            if(qName.equalsIgnoreCase("nickname")) {
                isNickname= true;
            } else if(qName.equalsIgnoreCase("fullname")) {
                isFullname =true;
            } else if(qName.equalsIgnoreCase("email")) {
                isemail = true;
            } else if(qName.equalsIgnoreCase("address")) {
                isAdress = true ;
            } else if(qName.equalsIgnoreCase("brithday")) {
                isBirthday = true;
            }
        }
        if(qName.equalsIgnoreCase("book")) {
            isBook = true;
            author = new Author();
        }
        if(isBook) {
            if(qName.equalsIgnoreCase("title")) {
                isTitle = true;
            } else if(qName.equalsIgnoreCase("nickname2")) {
                isNickname2 = true;
            } else if (qName.equalsIgnoreCase("price")) {
                isPrice = true ;
            } else if(qName.equalsIgnoreCase("nxb")) {
                isNxb = true;
            } else if(qName.equalsIgnoreCase("desciption")) {
                isdesciption = true;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        // đọc xog thẻ đóng close tag.
        if(qName.equalsIgnoreCase("author")) {
            isAuthor = false;
            authorlist.add(author);
            author = null;
        }
        if(isAuthor) {
            if(qName.equalsIgnoreCase("nickname")) {
                isNickname= false;
            } else if(qName.equalsIgnoreCase("fullname")) {
                isFullname =false;
            } else if(qName.equalsIgnoreCase("email")) {
                isemail = false;
            } else if(qName.equalsIgnoreCase("address")) {
                isAdress = false ;
            } else if(qName.equalsIgnoreCase("brithday")) {
                isBirthday = false;
            }
        }
        if(qName.equalsIgnoreCase("book")) {
            isBook = false;
            booklist.add(book);
            book = null;
        }

        if(isBook) {
            if (qName.equalsIgnoreCase("title")) {
                isTitle = false;
            } else if (qName.equalsIgnoreCase("nickname2")) {
                isNickname2 = false;
            } else if (qName.equalsIgnoreCase("price")) {
                isPrice = false;
            } else if (qName.equalsIgnoreCase("nxb")) {
                isNxb = false;
            } else if (qName.equalsIgnoreCase("desciption")) {
                isdesciption = false;
            }
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        // nội dung được đọc trong thẻ
        String str = String.valueOf(ch,start,length);
        if(isAuthor) {
           if(isNickname) {
               author.setNickname(str);
           }else if(isFullname) {
               author.setFullname(str);
           }else if(isemail){
               author.setEmail(str);
           } else if(isAdress) {
               author.setAddress(str);
           } else if(isBirthday){
               author.setBirthdays(str);
           }
        }

        if(isBook) {
            if (isNickname2) {
                book.setNickname(str);
            } else if(isPrice) {
                book.setPrice(Float.parseFloat(str));
            } else if (isNxb) {
                book.setNxb(str);
            } else if (isdesciption) {
                book.setDesciption(str);
            } else if (isTitle){
                book.setTitle(str);
            }

        }

    }

}
