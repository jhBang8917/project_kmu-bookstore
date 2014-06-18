/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation;

import boundary.MemberFacade;
import javax.ejb.EJB;
import entities.Member;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author G.W. Ryu
 */
@ManagedBean
@RequestScoped
public class MemberRegisterView {
    @EJB
    private MemberFacade memberFacade;
    private Member member;

    /**
     * Creates a new instance of MemberRegisterView
     */
    public MemberRegisterView() {
        this.member = new Member();
    }

    public Member getMember() {
        return member;
    }
    
    public int getNumberOfMembers(){
        return memberFacade.findAll().size();
    }
    
    public String postMember(){
        this.memberFacade.create(member);
        return "registerdmemberview";
    }
    
    
    
}
