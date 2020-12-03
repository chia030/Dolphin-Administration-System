import java.util.*;
import java.io.*;
import java.time.*;

public class MemberList{

   LocalDate date;

   private ArrayList<Member> members;   
   
   //CONSTRUCTOR:
   public MemberList() throws FileNotFoundException /*maybe we should catch this exception*/ {
   
        ArrayList<Member> members = new ArrayList<Member>();        
        scanFile();
   
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
   
     for (int i=0; i <= members.size(); i++) { 
        if (members.get(i).getID() == ID) existingID = true;
        else existingID = false;
     }
     
     return existingID;

   }
   
   //Deletes member based on ID
   public void deleteMember(int newID){
      for (int i = 0; i <= members.size(); i++){
         if (members.get(i).getID() == newID){
            members.remove(i);
         }
      }
   }
   
   //Loads file
   public void scanFile() throws FileNotFoundException{
      Scanner scanFile = new Scanner(new File("Member List.txt"));
      while (scanFile.hasNextLine()){
      
         addMember(new Member(scanFile.nextInt(), scanFile.next(),
         date.of(scanFile.nextInt(), scanFile.nextInt(), scanFile.nextInt()), scanFile.next(), scanFile.next(), scanFile.next(), scanFile.nextBoolean(), 
         date.of(scanFile.nextInt(), scanFile.nextInt(), scanFile.nextInt()), scanFile.nextBoolean()));
         
      }
   }
   
   //Prints all contents of member list
   public void printMembers(){
      for (int i = 0; i <= members.size(); i++){
         System.out.println(members.get(i).toString());
      }
   }
   
   
   //Prints the list that shows the unpaid members at the top and paid ones on the bottom (for the treasurer)
    public void printTrList() {
        for (int i = 0; i <= members.size(); i++) {
            if (!members.get(i).getValidity()) {
                System.out.println(members.get(i).toString());
               }
            }
        for (int i = 0; i <= members.size(); i++) {
            if (members.get(i).getValidity()) {
                System.out.println(members.get(i).toString());
            }
        }
    }
       
   
   //Saves to file (when exiting program): or why use if statements when you can use try and catch :)
   public void save() throws FileNotFoundException{
      PrintStream save = new PrintStream(new File ("Member List.txt"));
      try{
         try{
            for (int i = 0; i <= (members.size() - 1); i++){
               save.println(members.get(i).memberFileSave());
            }
            save.print(members.get(members.size() - 1).memberFileSave());
         }catch (Exception e){
            save.print(members.get(0).memberFileSave());
         }
      }catch (Exception e) { e.printStackTrace(); }
   }
   
}


