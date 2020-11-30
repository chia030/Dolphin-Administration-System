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
        
        //WORK IN PROGRESS...
        
        switch(u) {
        
            case CHAIRMAN:
                System.out.print("\n\nWelcome Chairman!\n\n");
                break;
                
            case TREASURER:
                System.out.print("\n\nWelcome Treasurer!\n\n");
                break;
                
            case COACH:
                System.out.print("\n\nWelcome Coach!\n\n");
                break;
        
        }
        
    }    
    

   public static Scanner scan = new Scanner(System.in);
   public static boolean s;
   
    
   public static final int PAUSETIME = 2000; //this will give the users time to read what the console prints
   public static final String CLEARCONSOLE = "\n\n\n\n\n\n\n\n"; //clears the console

   public static void systemStart() throws InterruptedException {
    
       
      System.out.println("\n\n-------------Welcome to the Dolphin Administration System-------------\n\n");
      Thread.sleep(PAUSETIME);
      System.out.println(CLEARCONSOLE);
       
       
//    GUEST HOME SCREEN LOOP:
      do {
       
         s = false;
         userTYPE = null;
       
         System.out.println("What would you like to do?\n\nPress [L] to login or [Q] to quit...\n");
       
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
         userID = Integer.parseInt(scan.next());
         
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
         userPIN = Integer.parseInt(scan.next());
          
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
   
   public static void homeChairman() {}
   
   public static void homeTreasurer() {}
   
   public static void homeCoach() {}
   
   


}