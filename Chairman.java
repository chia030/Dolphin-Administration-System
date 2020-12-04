import java.io.*;
import java.time.*;
import java.util.*;

public class Chairman extends Employee {

    public Chairman() {
     
        super(UserType.CHAIRMAN);
     
     }

    public void registerMember(String name, LocalDate birth, String address, String disc, String membership, boolean level, MemberList ml) {
    
        ml.addMember(new Member(name, birth, address, disc, membership, level, ml));
    
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
