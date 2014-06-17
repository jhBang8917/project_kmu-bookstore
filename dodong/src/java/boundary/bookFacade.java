/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boundary;

import entities.Book;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author G.W. Ryu
 */
@Stateless
public class bookFacade extends AbstractFacade<Book> {
    @PersistenceContext(unitName = "dodongPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public bookFacade() {
        super(Book.class);
    }
    
}
