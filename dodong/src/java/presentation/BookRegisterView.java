/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation;

import boundary.bookFacade;
import entities.Book;
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
    
    public String postBook(){
        
        this.bookFacade.create(book);
        return "registedbookview";
        
    }
    
}
