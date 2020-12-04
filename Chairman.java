import java.io.*;
import java.time.*;
import java.util.*;

public class Chairman extends Employee {

    public Chairman() {
     
        super(UserType.CHAIRMAN);
     
     }

    public void registerMember(Member m, MemberList ml) {
    
        ml.addMember(new Member(m.getName(), m.getDOB(), m.getAddress(), m.getDiscipline(), m.getType(), m.getActivityLevel(), ml));
    
    }
    
    public Member findMember(int ID, MemberList ml) {
    
        if (ml.findMember(ID) == null ) System.out.println("Member not found!");
        return ml.findMember(ID);
    
    }
   
   
    public void editMember(int ID, MemberList ml, int info) {
    
        findMember(ID, ml);
        
        switch(info) {
        
            case 1:
                
        
        
        
        }
    
    
    
    }
   
    public void assignCoach() {}
    

}
