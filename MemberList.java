import java.util.*;
import java.io.*;
import java.time.*;

public class MemberList{

   LocalDate date;

   private ArrayList<Member> members = new ArrayList<Member>();
   
//   Member m = new Member();
   
   //Adds a new member
   public void addMember(Member m){
      members.add(m);
   }
   
   //Deletes member based on ID
   public void deleteMember(int newID){
      for (int i = 0; i < members.size(); i++){
         if (members.get(i).getID() == newID){
            members.remove(i);
         }
      }
   }
   
   //Loads file
   public void scanFile() throws FileNotFoundException{
      Scanner scanFile = new Scanner(new File("Member List.txt"));
      while (scanFile.hasNextLine()){
         addMember(new Member(scanFile.nextInt(), scanFile.next(), date.of(scanFile.nextInt(), scanFile.nextInt(), scanFile.nextInt()), scanFile.next(), scanFile.next(), scanFile.next(), scanFile.nextBoolean()));
      }
   }
   
   //Prints all contents of member list
   public void printMembers(){
      for (int i = 0; i < members.size(); i++){
         System.out.println("ID: " + members.get(i).getID() + "\nName: " + members.get(i).getName() + "\nAge: " + members.get(i).getAge() + "\nAge group: " + members.get(i).getAgeRange() + "\nAddress: " + members.get(i).getAddress() + "\nDiscipline: " + members.get(i).getDiscipline() + "\nType: " + members.get(i).getType() + "\nValidity: " + members.get(i).getValidity() + "\nActivity: " + members.get(i).getActivityLevel() + "\n-----------------");
      }
   }
   
   //Saves to file (when exiting program): or why use if statements when you can use try and catch :)
   public void save() throws FileNotFoundException{
      PrintStream save = new PrintStream(new File ("Member List.txt"));
      try{
         try{
            for (int i = 0; i < (members.size() - 1); i++){
               save.println(members.get(i).getID() + " " + members.get(i).getName() + " " + members.get(i).getDOB().getYear() + " " + members.get(i).getDOB().getMonthValue() + " " + members.get(i).getDOB().getDayOfMonth() + " " + members.get(i).getAddress() + " " + members.get(i).getDiscipline() + " " + members.get(i).getType() + " " + members.get(i).getActivityLevel());
            }
            save.print(members.get(members.size() - 1).getID() + " " + members.get(members.size() - 1).getName() + " " + members.get(members.size() - 1).getDOB().getYear() + " " + members.get(members.size() - 1).getDOB().getMonthValue() + " " + members.get(members.size() - 1).getDOB().getDayOfMonth() + " " + members.get(members.size() - 1).getAddress() + " " + members.get(members.size() - 1).getDiscipline() + " " + members.get(members.size() - 1).getType() + " " + members.get(members.size() - 1).getActivityLevel());
         }catch (Exception e){
            save.print(members.get(0).getID() + " " + members.get(0).getName() + " " + members.get(0).getDOB().getYear() + " " + members.get(0).getDOB().getMonthValue() + " " + members.get(0).getDOB().getDayOfMonth() + " " + members.get(0).getAddress() + " " + members.get(0).getDiscipline() + " " + members.get(0).getType() + " " + members.get(0).getActivityLevel());
         }
      }catch (Exception e){}
   }
   
}