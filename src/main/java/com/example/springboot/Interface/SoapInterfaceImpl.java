package com.example.springboot.Interface;

//import com.example.springboot.hashdb.HashDB;
//import com.example.springboot.vo.BookVO;
 
import javax.jws.WebService;
 
@WebService(endpointInterface = "com.example.springboot.Interface.SoapInterface",
        serviceName="SoapInterface")
public class SoapInterfaceImpl implements SoapInterface {
    public String insertBook(BookVO bookVO) {
        HashDB.insertBook(bookVO);
        return "Book with name : " + bookVO.getBookName() + " is now available on the shelf";  //To change body of implemented methods use File | Settings | File Templates.
    }
 
    public BookVO getBook(String title) {
 
        return HashDB.getBook(title);  //To change body of implemented methods use File | Settings | File Templates.
    }
}