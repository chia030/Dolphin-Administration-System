/* 
      
   TO DO:
   
     1 - format dates so they will be displayed nicely with only the info that we need ("dd-MM-yyyy")
     2 - now we need something that limits the passive members' options, some method that will allow them to have access to the pool only in the morning for example:
         this could be done by changing their membership to be valid only during some hours of the day (so working with memValidity)
     3 - maybe we should change memType to a boolean and call it something like isCompetitive and then another boolean called hasCoach so that if isCompetitive is true,
         has coach will true too (upon creation of the member, so in the constructor)      
      
 */

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Member {

   private int memID;
   private String memName;
   private LocalDate memDOB;
   private int memAge; 
   private String address;
   private String favDiscipline;
   private int memPrice = 500;
   private LocalDate regDate;
   private String memType; //memType: "EXERCISE"/"ELITE"
   private String ageRange; //ageRange: "JUNIOR"/"SENIOR"
   private boolean memValidity = false;
   private boolean activityLevel; //activityLevel: ACTIVE(true)/PASSIVE(false)
   private static LocalTime passiveStart = LocalTime.parse("06:00");
   private static LocalTime passiveEnd = LocalTime.parse("16:00");
   
   public void setMembershipPrice(){
   
      if (this.ageRange.equals("Junior") && this.activityLevel){
         this.memPrice = 1000;
      } else if (this.ageRange.equals("Senior") && this.activityLevel && this.memAge < 60){
         this.memPrice = 1600;
      } else if (this.memAge >= 60 && this.activityLevel){
         this.memPrice = 1200;
      } else {
         this.memPrice = memPrice;
      }
      
   }  
   
   public String toString() { 
      return "ID: " + this.memID + " /nName: " + this.memName + " /nDate of Birth: " 
             + this.memDOB + " /nAge: " + this.memAge + " /nAddress: " + this.address + " /nDiscipline: " 
             + this.favDiscipline + " /nMembership price: " + this.memPrice + " /nRegistration date: " + this.regDate 
             + " /nMember level: " + this.memType + " /nAge classification: " + this.ageRange + " /nMembership validity: " 
             + this.memValidity + " /nMembership level: " + this.activityLevel + ".";
   }
   
// CONSTRUCTOR FOR THE registerMember() METHOD (Chairman Class):    
   public Member(String name, LocalDate birth, String address, String disc, String membership, boolean level) {
    
      this.setID();
      this.memName = name;
      this.memDOB = birth;
      this.address = address;
      this.favDiscipline = disc;
      this.memType = membership;
      this.activityLevel = level;
      this.regDate = LocalDate.now();
      this.setAge();
      this.setAgeRange();
      this.setMembershipPrice();
      
      //the validity will be set from the treasurer when they actually pay!!!
    
   }
   
   
// CONSTRUCTOR FOR THE MEMBERLIST:
   public Member(int ID, String name, LocalDate birth, String address, String disc, String membership, boolean level, LocalDate date, boolean validity) {
   
      this.memID = ID;
      this.memName = name;
      this.memDOB = birth;
      this.address = address;
      this.favDiscipline = disc;
      this.memType = membership;
      this.activityLevel = level;
   //      this.regDate = LocalDate.now(); //this will need to be read from a file!
      this.regDate = date;
      this.setAge();
      this.setAgeRange();
      this.setMembershipPrice();
      this.memValidity = validity;
      
   }

  
  //ID SETTER: there's a method to check for duplicates in the MemberList, it will be called upon the creation of a new Member!   
   public void setID() {
      Random r = new Random();
      memID = r.nextInt(9998) + 1; 
      this.memID = memID; 
   }
  
   public int getID() { 
      return this.memID; 
   }

    
   public void setName(String memName) { 
      this.memName = memName; 
   }
   
   public String getName() { 
      return this.memName; 
   }
    

   public void setDOB(LocalDate memDOB) { 
      this.memDOB = memDOB; 
   } 
   
   public LocalDate getDOB() { 
      return this.memDOB; 
   }
    
    
   public void setAddress(String address) { 
      this.address = address; 
   }
   
   public String getAddress() { 
      return this.address; 
   }
    
    
   public void setDiscipline(String favDiscipline) {
      this.favDiscipline = favDiscipline; 
   }
   
   public String getDiscipline() { 
      return this.favDiscipline; 
   }
    
    
   public void setRegDate(LocalDate regDate) { 
      this.regDate = regDate; 
   }
   
   public LocalDate getRegDate() { 
      return this.regDate; 
   }
    
    
   public void setType(String memType) { 
      this.memType = memType; 
   }
   
   public String getType() { 
      return this.memType; 
   }
    
    
    //calculateAge() is returning an ``int`` comparing the DOB and the current date
   public int calculateAge(LocalDate DOB) {  
      return Period.between(DOB, LocalDate.now()).getYears();  
   }
    
    
   public void setAge() { 
      this.memAge = calculateAge(this.memDOB); 
   }
   
   public int getAge() { 
      return this.memAge; 
   }
    
    

   public void setAgeRange() {  
      if ( this.getAge() < 18) ageRange = "Junior";
      else ageRange = "Senior";
        
   }
    
   public String getAgeRange() { 
      return this.ageRange; 
   }   
   
   
   public void setValidity(){ //Should work to set the validity? Someone else will have to check it for me though, because idk if it'll work with everything
      if ((this.activityLevel = false) && (LocalDate.now().isAfter(this.passiveStart)) && (LocalTime.now()isBefore(this.passiveEnd))){
         this.memValidity = true;
      }else if((this.activityLevel = false) && (LocalDate.now().isBefore(this.passiveStart)) || (LocalDate.now().isAfter(this.passiveEnd))){
         this.memValidity = false;
      }else{
         this.memValidity = true;
      }
   }
   
   public boolean getValidity() { 
      return memValidity; 
   }
    
    


// the ActivityLevel will be true when the membership is active and false when the membership is passive!
// there will be a method in the Treasurer class to set it to true
   public void setActivityLevel(boolean activityLevel) { 
      this.activityLevel = activityLevel; 
   }
   
   public boolean getActivityLevel() { 
      return activityLevel; 
   }
    

}
