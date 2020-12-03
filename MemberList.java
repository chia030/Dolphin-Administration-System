import java.util.*;
import java.io.*;
import java.time.*;

public class MemberList{

   LocalDate date;
   PrintWriter writer = null;
   FileWriter fw = null;

   private ArrayList<Member> members;   
   
   //CONSTRUCTOR:
   public MemberList(){
        
        membersFile();
        ArrayList<Member> members = new ArrayList<Member>();        
        scanFile();
   
   }
   
   public void membersFile() {
   
    try {
    
       fw = new FileWriter(DAS.MEMBERLISTFILE, true);
            
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
   
    boolean existingID = false;
   
     for (Member i: members) { 
        if (i.getID() == ID) existingID = true;
        else existingID = false;
     }
     
     return existingID;

   }
   
   //Deletes member based on ID
   public void deleteMember(int newID){
      for (Member i: members){
         if (i.getID() == newID){
            members.remove(i);
         }
      }
   }
   
   //Loads file
   public void scanFile() {
   
    try {
         
      Scanner scanFile = new Scanner(DAS.MEMBERLISTFILE);
      while (scanFile.hasNextLine()){
      
         addMember(new Member(scanFile.nextInt(), scanFile.next(),
         date.of(scanFile.nextInt(), scanFile.nextInt(), scanFile.nextInt()), scanFile.next(), scanFile.next(), scanFile.next(), scanFile.nextBoolean(), 
         date.of(scanFile.nextInt(), scanFile.nextInt(), scanFile.nextInt()), scanFile.nextBoolean()));
         
      }
      
    } catch (Exception e) { e.printStackTrace(); }
    
   }
   
   //Prints all contents of member list
   public void printMembers(){
      for (Member i: members){
         System.out.println(i.toString());
      }
   }
   
   
   //Prints the list that shows the unpaid members at the top and paid ones on the bottom (for the treasurer)
    public void printTrList() {
    
        for (Member i: members) {
            if (!i.getValidity()) {
                System.out.println(i.toString());
               }
            }
            
        for (Member j: members) {
            if (j.getValidity()) {
                System.out.println(j.toString());
            }
        }
    }
       
   
   //Saves to file (when exiting program): or why use if statements when you can use try and catch :)
   public void saveToFile() {
      
      try {
          fw = new FileWriter(DAS.MEMBERLISTFILE, false);
          writer = new PrintWriter(fw);
      } catch (Exception e) { e.printStackTrace(); }
      
      
      for (Member i: members) {
            writer.println(i.memberFileSave());
      }
      
      writer.close();      

      
//       try{
//          try{
//             for (int i = 0; i <= (members.size() - 1); i++){
//                writer.println(members.get(i).memberFileSave());
//             }
//             writer.print(members.get(members.size() - 1).memberFileSave());
//          }catch (Exception e){
//             writer.print(members.get(0).memberFileSave());
//          }
//       }catch (Exception e) { e.printStackTrace(); }
      
   }
   
}


