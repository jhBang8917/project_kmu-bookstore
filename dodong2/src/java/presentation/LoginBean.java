/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation;

import boundary.MemberFacade;
import entities.Member;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Wanjin
 */

@ManagedBean
@SessionScoped

public class LoginBean {
        @EJB
        MemberFacade memberFacade;
        Member member;
        Member current;
        String t;
      
       

	public LoginBean(){
            this.member = new Member();
        }
        
        public Member getMember(){
            return member;
        }
        
        public List<Member> getMemberList(){
        
        return memberFacade.findAll();
        
    }
        
        
	public boolean CheckValidUser(){
            String loginname = member.getUserID();
            String password = member.getPassword();
            t = " failed. DB is empty";
            List<Member> list = getMemberList();
            boolean again = true;
            
            if(!list.isEmpty()){
            Iterator<Member> iter = memberFacade.findAll().listIterator();
            Member current2;
            
            
            
            while(iter.hasNext() && again ){
            current2=iter.next();
            if(loginname.equals(current2.getUserID()) && password.equals(current2.getPassword())){
                System.out.println(loginname);
                again = false;
                this.current = current2;
                t = " succeed. Hi, ";
		
            }
            else{
			t=" failed";
		}
	}
            }
            return !again;
        }
        
      
        
        
        
        public String login(){
            
            if(CheckValidUser()){
                
                 HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                session.setAttribute("username", current);
                t = t + current.getUserID();
            }
            /*HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
            System.out.println("sdfsdf");
            if(CheckValidUser()){
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", current);
                t=t+current.getUserID();
                if (session == null) {
                    FacesContext.getCurrentInstance().getApplication().getNavigationHandler()
                                .handleNavigation(FacesContext.getCurrentInstance(),null, "/index.xhtml");
                } else {
                    Object currentUser = session.getAttribute("user");
                    if (currentUser == null || currentUser == "") {
                        FacesContext
                        .getCurrentInstance()
                        .getApplication()
                        .getNavigationHandler()
                        .handleNavigation(
                        FacesContext.getCurrentInstance(), null,
                        "/index.xhtml");
                    }
                
                }
            }*/
               
            
            return t;
            
        }
        
        
        
        public Member getCurrent() {
            return current;
        }

        public boolean isLoggedIn() {
            boolean loggedIn = false;
            String sessionID = getSessionID();
            //if(sessionID != null || !"".equals(sessionID))
              //  loggedIn = true;
            
            
           
            if(sessionID!=null && sessionID !="" && !sessionID.equals("nobody"))
                loggedIn = true;
                
            
            return loggedIn;
        }
        
        public String getSessionID(){
            javax.servlet.http.HttpServletRequest req =
            (javax.servlet.http.HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = req.getSession(false);
            
             if(!session.isNew()){
             Member sessionMem= (Member)session.getAttribute("username");
                if(sessionMem!=null){
                    String sessionID = sessionMem.getUserID();
                    return sessionID;
                }
                else
                    return"nobody";
             }
             else{
                 return "nobody";
             }
            //String sessionID = FacesContext.getCurrentInstance().getExternalContext().getSessionId(false);
            
        }
        
        public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }
        
        public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
    
}
