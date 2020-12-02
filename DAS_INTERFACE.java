import java.io.*; 
import java.util.*;

public class DAS_INTERFACE {

    public static int userID = 0;
    public static int userPIN = 0;
    public static UserType userTYPE;
    
    
//  GUEST CONSTRUCTOR: all the variables are null
    public DAS_INTERFACE() { 
       
        userID = 0;
        userPIN = 0;
        userTYPE = null;
        
    }
    
//  CONSTRUCTOR FOR LOGGED-IN USERS:
    public DAS_INTERFACE(UserType u) {
    
        this.userID = u.getID();
        this.userPIN = u.getPIN();
        this.userTYPE = u;
        
    }    
    

   public static Scanner scan = new Scanner(System.in);
   public static boolean s;
   
   
   public static final int SHORTPAUSE = 1500; 
   public static final int PAUSETIME = 2000; //this will give the users time to read what the console prints
   public static final String CLEARCONSOLE = "\n\n\n\n\n\n\n\n"; //clears the console
   
   
   public static void systemStart() throws InterruptedException {
    
      System.out.println("\n\n______________________________________________________________"); 
      System.out.println("\n                DOLPHIN ADMINISTRATION SYSTEM                \n");
      System.out.println("______________________________________________________________\n\n");
      Thread.sleep(PAUSETIME);
      System.out.println(CLEARCONSOLE);
      
      System.out.println("\nWELCOME!\n");
       
       
//    GUEST HOME SCREEN LOOP:
      do {
       
         s = false;
         userTYPE = null;
       
         System.out.println("\nWhat would you like to do?\n\nPress [L] to login or [Q] to quit...\n");
       
         switch (scan.next().toUpperCase()) {
          
            case "L":
               login();
               break;
                
            case "Q":
               System.out.println("Have a lovely day! :)");
               System.exit(0); //closes the application
               break;
                
            default:
               s = true;
               System.out.println("Please enter a valid input!\n");
         
         }
       
      } while (s);
//    END OF GUEST HOME SCREEN LOOP.      
           
   }

   public static void login() throws InterruptedException {
      
      boolean sentinel;
      int cnt = 0; //this will count the failed login attempts
   

//    ID LOOP:    
      do {
       
         sentinel = false;
      
         System.out.print("\nUSER ID: ");
         
         try { 
            
            userID = Integer.parseInt(scan.next());
            
         } catch (Exception e) { userID = 0; } //catching input that cannot be converted into an ``int``
         
         
            if (!(userID==UserType.CHAIRMAN.getID() || userID==UserType.TREASURER.getID() || userID==UserType.COACH.getID())) {
         
                sentinel = true; 
                System.out.println("\nPlease enter a valid ID number!\n");
             
            }
 
      } while(sentinel);
//    END OF ID LOOP.

       
          
//    PIN LOOP:       
      do {
          
         sentinel = false;
         System.out.print("\nPIN: ");
         
         try {
         
             userPIN = Integer.parseInt(scan.next());
             
             } catch (Exception e) { userPIN = 0; } //catching input that cannot be converted into an ``int``
              
             if (userPIN==UserType.CHAIRMAN.getPIN() && userID==UserType.CHAIRMAN.getID()) { userTYPE = UserType.CHAIRMAN; }
              
             else if (userPIN==UserType.TREASURER.getPIN() && userID==UserType.TREASURER.getID()) { userTYPE = UserType.TREASURER; }
              
             else if (userPIN==UserType.COACH.getPIN() && userID==UserType.COACH.getID()) { userTYPE = UserType.COACH; }
              
             else {
              
                System.out.println("\nInvalid PIN!\n");
                cnt++; //increasing the count of failed PIN attempts each time
                 
                if(cnt<=2) {
                 
                   System.out.println("\nPress [T] to try again or [B] to go back...\n");
                    
                   switch (scan.next().toUpperCase()) {
                       
                      case "T":
                         sentinel = true;
                         break;
                             
                      case "B":
                         s = true;
                         return; //goes back to useSystem()
                             
                      default:
                         s = true;
                         System.out.println("\nInvalid input! Returning to home...\n");
                         Thread.sleep(PAUSETIME);
                         System.out.println(CLEARCONSOLE);
                         return; //goes back to useSystem()
                       
                   }
                    
                }
                  
                else { 
                  
                   s = true;
                   System.out.println("\n3 failed attempts. Returning to home...\n");
                   Thread.sleep(PAUSETIME);
                   System.out.println(CLEARCONSOLE);
                   return; //goes back to useSystem()
                    
                }
                    
             
             }

      } while(sentinel);
//    END OF PIN LOOP.

   }
   
   public static void userInterface() throws InterruptedException {

        switch(userTYPE) {
        
            case CHAIRMAN:
                homeChairman();
                break;
                
            case TREASURER:
                homeTreasurer();
                break;
                
            case COACH:
                homeCoach();
                break;
        
        }   
   
   }
 
 
 //add another option for the users to quit the system directly from their hub
   
   
   public static void homeChairman() throws InterruptedException {
   
    boolean sentinel;
    System.out.println("\n\nWelcome Chairman!\n\n");
    Chairman chairman = new Chairman();
    
//  CHAIRMAN HOME LOOP:
    do {
    
        sentinel = false;
    
        System.out.println("\nPlease select one of the following options:\n");
        System.out.println("\n- [A] to REGISTER NEW MEMBER\n- [B] to EDIT MEMBER INFO\n- [C] to VIEW MEMBERS\n- [Q] to LOG OUT\n");
    
        switch (scan.next().toUpperCase()) {
        
            case "A":
                break;
                
            case "B":
                break;
                
            case "C":
                break;
                
            case "Q":
                DAS.sentinelDAS = true;
                System.out.println("\nThank you for your work, Chairman!\nHave a lovely day :)\n");
                Thread.sleep(SHORTPAUSE);
                System.out.println(CLEARCONSOLE);
                break;
                
            default:
                sentinel = true;   
        
        
        }
        
     } while(sentinel);
//  END OF CHAIRMAN HOME LOOP.    
   
   }
   
   public static void homeTreasurer() throws InterruptedException {
   
    boolean sentinel;
    System.out.println("\n\nWelcome Treasurer!\n\n");
    Treasurer treasurer = new Treasurer();


//  TREASURER HOME LOOP:    
    do {
    
        sentinel = false;
    
        System.out.println("\nPlease select one of the following options:\n");
        System.out.println("\n- [A] to REGISTER NEW PAYMENT\n- [B] to VIEW MEMBERS BEHIND WITH PAYMENT\n- [C] to VIEW MEMBERS\n- [Q] to LOG OUT\n");
    
        switch (scan.next().toUpperCase()) {
        
            case "A":
                break;
                
            case "B":
                break;
                
            case "C":
                break;
                
            case "Q":
                DAS.sentinelDAS = true;
                System.out.println("\nThank you for your work, Treasurer!\nHave a lovely day :)\n");
                Thread.sleep(SHORTPAUSE);
                System.out.println(CLEARCONSOLE);
                break;
                
            default:
                sentinel = true;   
        
        
        }
        
     } while(sentinel);
//  END OF TREASURER HOME LOOP.     

   
   }
   
   public static void homeCoach() throws InterruptedException {
   
    boolean sentinel;
   
    System.out.println("\n\nWelcome Coach!\n\n");
    Coach coach = new Coach();
    
//  COACH HOME LOOP:    
    do {
    
        sentinel = false;
    
        System.out.println("\nPlease select one of the following options:\n");
        System.out.println("\n- [A] to REGISTER NEW RESULT\n- [B] to VIEW RANKINGS\n- [C] to VIEW ALL MEMBERS IN TRAINING\n- [Q] to LOG OUT\n");
    
        switch (scan.next().toUpperCase()) {
        
            case "A":
                break;
                
            case "B":
                break;
                
            case "C":
                break;
                
            case "Q":
                DAS.sentinelDAS = true;
                System.out.println("\nThank you for your work, Coach!\nHave a lovely day :)\n");
                Thread.sleep(SHORTPAUSE);
                System.out.println(CLEARCONSOLE);
                break;
                
            default:
                sentinel = true;   
        
        
        }
        
     } while(sentinel);
//  END OF COACH HOME LOOP.       
   
   }
   
   


}