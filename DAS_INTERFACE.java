import java.io.*; 
import java.util.*;

public class DAS_INTERFACE {


   public static Scanner scan = new Scanner(System.in);
   public static boolean s;
   
    
   public static final int PAUSETIME = 2000; //this will give the users time to read what the console prints
   public static final String CLEARCONSOLE = "\n\n\n\n\n\n\n\n"; //clears the console

   public static void useSystem() throws InterruptedException {
    
       
      System.out.println("\n\n-------------Welcome to the Dolphin Administration System-------------\n\n");
      Thread.sleep(PAUSETIME);
      System.out.println(CLEARCONSOLE);
       
       
//    HOME SCREEN LOOP:
      do {
       
         s = false;
       
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
//    END OF HOME SCREEN LOOP.      
           
   }

   public static void login() throws InterruptedException {
       
      int userID = 0;
      int userPW = 0;
      boolean sentinel;
      int cnt = 0; //this will count the failed login attempts
   

//    ID LOOP:    
      do {
       
         sentinel = false;
      
         System.out.print("\nUSER ID: ");
         userID = Integer.parseInt(scan.next());
          
       
         switch(userID) {
             
             //I dunno what this is doing quite yet
          
            case 1:
                //Chairman chairman = new Chairman();
               break;
                
            case 2:
                //Treasurer treasurer = new Treasurer();
               break;
                
            case 3:
                //Coach coach = new Coach();
               break;
                
            default:
               sentinel = true;
               System.out.println("\nPlease enter a valid ID number!\n");
          
         }
             
      } while(sentinel);
//    END OF ID LOOP.

       
          
//    PIN LOOP:       
      do {
          
         sentinel = false;
         System.out.print("\nPIN: ");
         userPW = Integer.parseInt(scan.next());
          
          //something else will happen after the welcome messages are printed, work in progress!
          
         if (userPW==1111 && userID==1) { System.out.print("\n\nWelcome Chairman!\n\n"); }
          
         else if (userPW==2222 && userID==2) { System.out.print("\n\nWelcome Treasurer!\n\n"); }
          
         else if (userPW==3333 && userID==3) { System.out.print("\n\nWelcome Coach!\n\n"); }
          
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
    

//     I don't think these are really needed:
//   
//     public static void goBack() {}
//     
//     public static void exitSystem() {}


}