package com.example.springboot.vo;


import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
 
@XmlRootElement(name = "Book")
public class SoapVo implements Serializable {
 
    private long bookId;
    private String bookName;
    private String author;
 
    public long getBookId() {
        return bookId;
    }
 
    public void setBookId(long bucketId) {
        this.bookId = bookId;
    }
 
    public String getBookName() {
        return bookName;
    }
 
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
 
    public String getAuthor() {
        return author;
    }
 
    public void setAuthor(String author) {
        this.author = author;
    }
}
