/* 
 
 This is Chiara's edited version of the Member class! I had to do some changes because I couldn't work with the previous version... :(
   What changed (29/11 @ 16:30) : 
   
      - added memDOB (date of birth);
      - changed the variables to "mem<Variable>" so we don't get confused with the other classes
      - added a method that will automatically calculate the age, comparing the DOB with the current date (it might need some fixing in the future depending on how we'll use it!)
      - fixed the return statements in the getters so that they return the values of the object `` this.<variable> ``
      - edited the constructor slightly, I will probably have to add more changes to it
      - formatted all the getters and setters
      - set memValidity to default to ``false`` when instantiated so no one will get away with payments
      
   TO DO:
   
      - format dates so they will be displayed nicely with only the info that we need ("dd-MM-yyyy")
      - perhaps add a toString method? where will it be used?
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
   private int membershipPrice = 500;
   private String favDiscipline;
   private int memPrice = 500;
   private LocalDate regDate;
   private String memType;
   private String ageRange;
   private boolean memValidity = false;
   private boolean activityLevel;
   
   Random r = new Random();
   
   private double setMembershipPrice(){ // Unsure if this will work. Need some way to define the memType. Enum maybe? I just don't know how to do an Enum.
      if (this.memAge < 18 && this.memType.equals("Active")){
         this.memPrice = 1000;
      }else if (this.memAge >= 18 && this.memType.equals("Active") && this.memAge < 60){
         this.memPrice = 1600;
      }else if (this.memAge >= 60 && this.memType.equals("Active")){
         this.memPrice = 1200;
      }else{
         this.memPrice = memPrice;
      }
      return memPrice;
   }
    
   public Member(int ID, String name, LocalDate birth, String address, String disc, String membership, boolean level) {
    
      this.memID = ID;
      this.memName = name;
      this.memDOB = birth;
      this.address = address;
      this.favDiscipline = disc;
      this.memType = membership;
      this.activityLevel = level;
      this.regDate = LocalDate.now();
      this.setAge();
      this.setAgeRange();
      setMembershipPrice();
      setID(); //Not sure if this belongs here?
       
       //the validity will be set from the treasurer when they actually pay!!!
    
   }

     
   public void setID(int memID) { //This should work to set the memID to be a random number from 1-9999 I think? Call it in the constructor maybe?
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
      return this.ageRange; }


   public void setValidity(boolean memValidity) { 
      this.memValidity = memValidity; 
   }
   
   public boolean getValidity() { 
      return memValidity; 
   }
    
    


    //the ActivityLevel will be true when the membership is active and false when the membership is passive!
   public void setActivityLevel(boolean activityLevel) { 
      this.activityLevel = activityLevel; 
   }
   
   public boolean getActivityLevel() { 
      return activityLevel; 
   }
    

}
