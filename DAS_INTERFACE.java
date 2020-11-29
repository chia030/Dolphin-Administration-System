import java.io.*; 
import java.util.*;

public class DAS_INTERFACE {

    //just using as a test, nothing permanent

    public static Scanner scan = new Scanner(System.in);
    
    public static final int PAUSETIME = 2000;
    public static final String CLEARCONSOLE = "\n\n\n\n\n\n\n\n"; //clears the console

    public static void useSystem() throws InterruptedException {
    
//       Scanner scan = new Scanner(System.in);
       
       System.out.println("-------------Welcome to the Dolphin Administration System-------------");
       Thread.sleep(PAUSETIME);
       System.out.println(CLEARCONSOLE);
       
       login();
    
    }

    public static void login() {
    
       System.out.print("USER ID: ");
       int userID = scan.nextInt();
       
       System.out.println(" ");
       
       System.out.print("PIN: ");
       int userPW = scan.nextInt();

    }
        
    public static void goBack() {}
    
    public static void exitSystem() {}


}