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
    

   
   
    public void editMember(Member m, MemberList ml, int info) {
    
//        findMember(ID, ml);
        
//         switch(info) {
//         
//             case 1:
//                 
//         
//         
//         
//         }
    
    //work in progress!
    
    }
   
    public void assignCoach() {
    
        //this function of the chairman class will be implemented in the future 
    
    }
    

}
