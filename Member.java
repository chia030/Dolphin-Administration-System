/* 
      
   TO DO:

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
   private static LocalTime passiveHoursStart = LocalTime.parse("06:00");
   private static LocalTime passiveHoursEnd = LocalTime.parse("16:00");
   private boolean memCard = false;
   private String lastPaymentMethod;
   
   
   public void setMembershipPrice(){
   
      if (this.ageRange.equals("JUNIOR") && this.activityLevel){
         this.memPrice = 1000;
      } else if (this.ageRange.equals("SENIOR") && this.activityLevel && this.memAge < 60){
         this.memPrice = 1600;
      } else if (this.memAge >= 60 && this.activityLevel){
         this.memPrice = 1200;
      } else {
         this.memPrice = memPrice;
      }
      
   }
   
   public int getPrice() {
        return this.memPrice;
   }
   
   public String toString() { 
      return "ID: " + this.memID + " \nName: " + this.memName + " \nDate of Birth: " 
             + this.memDOB + " \nAge: " + this.memAge + " \nAddress: " + this.address + " \nDiscipline: " 
             + this.favDiscipline + " \nMembership price: " + this.memPrice + ".00DKK \nRegistration date: " + this.regDate 
             + " \nMember level: " + this.memType + " \nAge classification: " + this.ageRange + " \nMembership validity: " 
             + this.memValidity + " \nMembership level: " + this.activityLevel + ".\n\n\n";
   }
   
   public String memberFileSave() {
   
      return this.memID+" "+this.memName+" "+this.memDOB.getYear()+" "+this.memDOB.getMonthValue()+" "+this.memDOB.getDayOfMonth()+" "+this.address+" "
         +this.favDiscipline +" "+this.memType+" "+this.activityLevel+" "+this.regDate.getYear()+" "+this.regDate.getMonthValue()+" "+this.regDate.getDayOfMonth()
         +" "+this.memValidity;
   
   }
   
   public Member() {}
   
   
// CONSTRUCTOR FOR THE registerMember() METHOD (Chairman Class):    
   public Member(String name, LocalDate birth, String address, String disc, String membership, boolean level, MemberList ml) {
   
      do { this.setID(); } while (ml.checkID(this.memID) == true); //this is making sure we don't have the same ID more than once

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
      
//    memValidity and memCard will be set by the treasurer when they actually pay!
    
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

      this.regDate = date;
      this.setAge();
      this.setAgeRange();
      this.setMembershipPrice();
      this.memValidity = validity;
      
   }

  
 //ID SETTER: there's a method to check for duplicates in the MemberList, it will be called upon the creation of a new Member!   
   public void setID() {
      Random r = new Random();
      memID = r.nextInt(9998) + 1000; 
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
   
   public void setDOB_2(int year, int month, int day) {
      this.memDOB = LocalDate.of(year, month, day);
   } 
   
   public LocalDate getDOB() { 
      return this.memDOB; 
   }
   
   public String formatDOB() {
   
    String prettyDOB = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(this.memDOB);
    
    return prettyDOB;
   
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
    
      if ( this.getAge() < 18) ageRange = "JUNIOR";
      else ageRange = "SENIOR";
        
   }
    
   public String getAgeRange() { 
      return this.ageRange; 
   }   
   
// MAKES THE MEMBERSHIP CARD WORK IF PERMITTED: the passive members are only allowed to the pool at certain times!   
   public void setCard(){
      
      if(this.memValidity == true && this.activityLevel == false && LocalTime.now().isAfter(this.passiveHoursStart) && LocalTime.now().isBefore(this.passiveHoursEnd)){
         this.memCard = true;
      } 
      
      else if(this.memValidity == true && this.activityLevel == false && LocalTime.now().isBefore(this.passiveHoursStart) || LocalTime.now().isAfter(this.passiveHoursEnd)){
         this.memCard = false;
      }  
      else if(this.memValidity == true && this.activityLevel == true) {
         this.memCard = true;
      }
      
   }
   
   public boolean getValidity() { 
      return memValidity; 
   }
   
   public void setValidity() {
   
    this.memValidity = true;
   
   }
    
    


// the ActivityLevel will be true when the membership is active and false when the membership is passive!
// there will be a method in the Treasurer class to set it to true
   public void setActivityLevel(boolean activityLevel) { 
      this.activityLevel = activityLevel; 
   }
   
   public boolean getActivityLevel() { 
      return activityLevel; 
   }
    
   public void setPaymentMethod(String pm) {
   
    this.lastPaymentMethod = pm;

   }

}
