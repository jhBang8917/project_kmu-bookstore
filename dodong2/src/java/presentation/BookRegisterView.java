/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation;

import boundary.bookFacade;
import entities.Book;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author G.W. Ryu
 */
@ManagedBean
@RequestScoped
public class BookRegisterView {
    @EJB
    private bookFacade bookFacade;
    private Book book;

    /**
     * Creates a new instance of BookRegisterView
     */
    public BookRegisterView() {
        
        this.book = new Book();
        
    }

    public Book getBook() {
        return book;
    }
    
    public int getNumberOfBooks(){
        
        return bookFacade.findAll().size();
        
    }
    
    public List<Book> getBookList(){
        
        return bookFacade.findAll();
        
    }//end of getBookList
    
    public List<Book> getInStockBookList(){
        
        List<Book> bookList = getBookList();
        ListIterator it = bookList.listIterator();
        Book book;
        
        while(it.hasNext()){
            
            book = (Book)it.next();
            if(book.getStock()==0){
                
                it.remove();
                
            }//end of if
           
        }//end of while
        
        
        return bookList;
        
    }//end of getInStockBookList
    
    public String postBook(){
        
        this.bookFacade.create(book);
        return "registedbookview";
        
    }
    
}
