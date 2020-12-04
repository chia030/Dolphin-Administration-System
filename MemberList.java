import java.util.*;
import java.io.*;
import java.time.*;

public class MemberList{

   LocalDate date;
   PrintWriter writer = null;
   FileWriter fw = null;

   private ArrayList<Member> members;   
   
   //CONSTRUCTOR:
   public MemberList() {
        
        File file = new File(DAS.MEMBERLISTFILE);
        membersFile();
        members = new ArrayList<Member>();        
        scanFile(file);
   
   }
   
   public ArrayList<Member> getMemberList() { return members; }
   
   public void membersFile() {
   
    try {
        
       fw = new FileWriter(DAS.MEMBERLISTFILE, true); //true = it is going to append to the existing file (if there is one)
         
     } catch (Exception e) { e.printStackTrace(); }    

   }
   
   //Returns the size
   public int getSize(){
      return members.size();
  }

  //method to get result at an index
  public Member getIndex(int i){
   return members.get(i);
}
   
   //Adds a new member
   public void addMember(Member m){
      members.add(m);
   }
   
   
// TO MAKE SURE THE MEMBERS DON'T GET THE SAME ID WHEN THEY ARE CREATED:
   public boolean checkID(int ID) {

     for (Member i: members) { 
        if (i.getID() == ID) return true; //if it finds the ID
     }
     
     return false; //if it doesn't find the ID

   }

// SEARCHES FOR A SPECIFIC MEMBER WITH THE ID:
   public Member findMember(int ID) {
   
         for (Member i: members) {
            if (i.getID() == ID) return i; //if it finds the ID
         }  

        return null; //if it doesn't find the ID    
   }
   
// DELETES MEMBER BASED ON THE ID
   public void deleteMember(int ID){
      for (Member i: members){
         if (i.getID() == ID) members.remove(i);
      }
   }
   
 //LOADING MEMBERS FROM lists/MemberList.txt
   public void scanFile(File f) {
   
    try {
         
      Scanner scanFile = new Scanner(f);
      
      //needs to be smarter but it works for now
      
      scanFile.useDelimiter("\s|\r\n"); // \s = space OR \r = end of line, \n = new line
      while (scanFile.hasNext()){
           


         addMember(

         new Member(
         

         scanFile.nextInt(), //ID
         scanFile.next(),   //Name
         date.of(scanFile.nextInt(), scanFile.nextInt(), scanFile.nextInt()), //DOB
         scanFile.next(), //Address
         scanFile.next(), //Discipline
         scanFile.next(), //Type
         scanFile.nextBoolean(), //Activity level
         date.of(scanFile.nextInt(), scanFile.nextInt(), scanFile.nextInt()), //RegDate
         scanFile.nextBoolean())); //validity
         
         
      }
      
    } catch (Exception e) { e.printStackTrace(); }
    
   }
   
   //Prints all contents of member list
   public void printMembers(){
      for (Member i: members){
         System.out.println(i);
      }
   }
   
   
   //Prints the list that shows the unpaid members at the top and paid ones on the bottom (for the treasurer)
    public void printTrFullList() {
    
        for (Member i: members) {
            if (!i.getValidity()) System.out.println(+i.getID()+" "+i.getName()+"\n"); // + NOT PAID
            }
            
        for (Member j: members) {
            if (j.getValidity()) System.out.println(j.getID()+" "+j.getName()+"\n"); // + PAID
        }
    }
    
    public void printTrRedList() {
            for (Member i: members) {
                if (!i.getValidity()) System.out.println(i.getID()+" "+i.getName()+"\n");
            }
    }
       
   
   //Saves to file (when exiting program)
   public void saveToFile() {
      
      try {
          fw = new FileWriter(DAS.MEMBERLISTFILE, false); //false = it is not going to append to the existing file (if there is one) but instead overwrite it
          writer = new PrintWriter(fw);
      } catch (Exception e) { e.printStackTrace(); }
      
      
      for (Member i: members) {
            writer.println(i.memberFileSave());
      }
      
      writer.close();      
      
   }
   
}


