//package com.example.springboot.Interface;

//public interface SoapInterface {

//}

package com.example.springboot.Interface;

import com.aranin.weblog4j.vo.BookVO;
 
import javax.jws.WebMethod;
import javax.jws.WebService;
 
@WebService
public interface SoapInterface {
 
    @WebMethod
    public  String insertBook(BookVO bookVO);
    @WebMethod
    public  BookVO getBook(String title);
}
