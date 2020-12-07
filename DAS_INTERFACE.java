import java.io.*; 
import java.util.*;
import java.time.*;

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
   public static Scanner sc = new Scanner(System.in).useDelimiter("\\n");
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
   
   public static void userInterface() throws InterruptedException, FileNotFoundException {
   
        MemberList ml = new MemberList();
        ResultsList rl = new ResultsList();

        switch(userTYPE) {
        
            case CHAIRMAN:
                homeChairman(ml);
                break;
                
            case TREASURER:
                homeTreasurer(ml);
                break;
                
            case COACH:
                homeCoach(ml,rl);
                break;
        
        }   
   
   }
 
 
 //add another option for the users to quit the system directly from their hub
   
   
   public static void homeChairman(MemberList ml) throws InterruptedException {
   
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
                newMember(chairman, ml);
                ml.saveToFile();
                sentinel = true;
                break;
                
            case "B":
                editMember(chairman, ml);
                ml.saveToFile();
                sentinel = true;
                break;
                
            case "C":
                chairman.showMemberList(ml); //the list should be displayed more nicely and with less information :(
                sentinel = true;
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
   
   
   
   public static void homeTreasurer(MemberList ml) throws InterruptedException {
   
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
                newPayment(treasurer, ml);
                ml.saveToFile();
                sentinel = true;
                break;
                
            case "B":
                ml.printTrRedList(); //then it should be able to select one and add payments maybe?? check SSD
                sentinel = true;
                break;
                
            case "C":
                treasurer.showMemberList(ml);
                sentinel = true;
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
   
   public static void homeCoach(MemberList ml, ResultsList rl) throws InterruptedException, FileNotFoundException {
   
    boolean sentinel;
   
    System.out.println("\n\nWelcome Coach!\n\n");
    Coach coach = new Coach();
    
    
//  COACH HOME LOOP:    
    do {
    
        sentinel = false;
    
        System.out.println("\nPlease select one of the following options:\n");
//        System.out.println("\n- [A] to REGISTER NEW RESULT\n- [B] to VIEW RANKINGS\n- [C] to VIEW ALL MEMBERS IN TRAINING\n- [Q] to LOG OUT\n");
        System.out.println("\n- [A] to REGISTER NEW RESULT\n- [B] to SHOW RANK\n- [C] to VIEW MEMBERS\n- [Q] to LOG OUT\n");
        
        switch (scan.next().toUpperCase()) {
        
            case "A":
                newResult(coach, ml, rl);
                rl.saveToFile();
                sentinel = true;
                break;
                
            case "B":
                seeTop(coach, rl);
                sentinel = true;
                break;
                

            case "C":
                coach.showMemberList(ml);
                sentinel = true;
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
   
   public static void newMember(Chairman chairman, MemberList ml) throws InterruptedException {
    
    boolean sentinel = false;
    
    
    Member member = new Member();
    
    String name, address;
    int dayDOB=0, monthDOB=0, yearDOB=0, discipline=0, type=0, level=0;

    System.out.println(CLEARCONSOLE);
    
    System.out.print("\n\nCreating a new DSC Member...\n\n\nLast Name: "); //memName //takes all sorts of ?!@ characters for now
    
    name = scan.next();
    member.setName(name);

        do {
        sentinel = false;
            System.out.print("\n\nDate of birth [DD][ENTER]/[MM][ENTER]/[YYYY][ENTER] : "); //memDOB (as 3 different ``int``)
            try {
                dayDOB = Integer.parseInt(scan.next());
                System.out.print(dayDOB+" / "); 
                monthDOB = Integer.parseInt(scan.next());
                System.out.print(dayDOB+" / "+monthDOB+" / ");
                yearDOB = Integer.parseInt(scan.next());
                } catch (InputMismatchException e) { System.out.println("\nYou can only use numbers."); dayDOB=0; monthDOB=0; yearDOB=0; }
            
         if (dayDOB>32 || dayDOB<1 || monthDOB>13 || monthDOB<1) { sentinel = true; System.out.println("\nThat's not a valid input!"); }
         
         // TRIES TO CREATE A ``LocalDate`` VALUE (OF memDOB) WITH THE GIVEN INPUT:
         try { member.setDOB_2(yearDOB, monthDOB, dayDOB); } catch (Exception e) { sentinel = true; System.out.println("\nThis format is invalid! :("); }
            
         } while (sentinel);
        
            
    System.out.print("\n\nAddress [CITY] (no numbers) : "); //address //takes all sorts of ?!@ characters for now //doesn't like numbers //fix
    
    //address = sc.next(); //this scanner will take in the entire line (but the file method does not support that)
    address = scan.next();
    member.setAddress(address);
    
    do {
        sentinel = false;
        System.out.print("\n\nPreferred Discipline: CHOOSE [1], [2], [3] OR [4].\n\n  1. BREASTSTROKE\n  2. FRONTCRAWL\n  3. BACKSTROKE\n  4. BUTTERFLY\n\n\n");
        System.out.print("Your choice: ");
        
        try {
        
            switch (discipline = Integer.parseInt(scan.next())) { //favDiscipline (as an ``int``)        
                case 1:
                    member.setDiscipline("BREASTSTROKE"); //also setting the corresponding ``String``
                    break;
                case 2:
                    member.setDiscipline("FRONTCRAWL");
                    break;
                case 3:
                    member.setDiscipline("BACKSTROKE");
                    break;
                case 4:
                    member.setDiscipline("BUTTERFLY");
                    break;    
             }
                     
        } catch (InputMismatchException e) { System.out.println("\nYou can only use numbers."); discipline = 0;}
        
        if (discipline<1 || discipline>4) { sentinel = true; System.out.println("\nThat's not a valid input!"); }
            
        } while (sentinel);
     
     
     do {
        sentinel = false;   
        System.out.print("\n\nExercise Type: CHOOSE [1] OR [2].\n\n  1. EXERCISE\n  2. ELITE\n\n\n");
        System.out.print("Your choice: ");
        try {
        
            switch(type = Integer.parseInt(scan.next())) {  //memType (as an ``int``)
                case 1:
                    member.setType("EXERCISE"); //also setting the corresponding ``String``
                    break;
                case 2:
                    member.setType("ELITE");
                    break;
            }

        } catch (InputMismatchException e) { System.out.println("\nYou can only use numbers."); type = 0; }
            
        if (type<1 || type>2) { sentinel = true; System.out.println("\nThat's not a valid input!"); }
        
        } while (sentinel); 
     
     do {
        sentinel = false;   
        System.out.println("\n\nMembership Level: CHOOSE [1] OR [2].\n\n  1. ACTIVE\n  2. PASSIVE\n\n\n");
        System.out.print("Your choice: ");
        try {
        
            switch (level = Integer.parseInt(scan.next())) {  //activityLevel (as an ``int``)
                case 1:
                    member.setActivityLevel(true); //also setting the corresponding ``boolean``
                    break;
                case 2:
                    member.setActivityLevel(false);
                    break;
            }
                     
        } catch (InputMismatchException e) { System.out.println("\nYou can only use numbers."); level = 0; }
            
        if (level<1 || level>2) { sentinel = true; System.out.println("\nThat's not a valid input!"); }
        
        } while (sentinel);
        
        String infoPrint = "Last Name: "+member.getName()+"\nDate of birth: "+member.getDOB()+"\nAddress: "+member.getAddress()+"\nPreferred Discipline: "+
                           member.getDiscipline()+"\nExercise Type: "+member.getType()+"\nActive Membership: "+member.getActivityLevel(); 
        
        
        System.out.println("This is the information of the new member: \n\n");
        System.out.println(infoPrint);
        Thread.sleep(SHORTPAUSE);
        
        
        do {
        
        System.out.println("\n\n\nWould you like to continue?? [Y] or [N]\n\n");
        
        boolean s = false;
        
        switch (scan.next().toUpperCase()) {
        
            
        
            case "Y":
                try {
                    chairman.registerMember(member, ml);
                    sentinel = false;
                    } catch (Exception e) { 
                        System.out.println("\n\nSomething went wrong :(\n\nReturning to home page...\n\n"); 
                        sentinel = true;
                        
                    }
                break;
            
            case "N":
                System.out.println("\n\nReturning to home page...\n\n");  //we should add another request for confirmation, they would lose all the progress!
                
                sentinel = true;
                
                break;
                
            default:
                System.out.println("\n\nPlease enter a valid input!\n\n");
                Thread.sleep(SHORTPAUSE);
                s = true;
                
        }
        
   } while (s);     
   if (sentinel == false) System.out.println("\n\nThe new member has been added successfully!\n\n");
   
   Thread.sleep(SHORTPAUSE);
   System.out.println(CLEARCONSOLE);
   
   }
   
// EDITS THE MEMBER INFO IN THE LIST (problems: doesn't ask for confirmation, should be displaying confirmation message at the end)
// should also be working with the chairman class in order to make sure the membership class is updated when they change the membership level
//add try - catch
   public static void editMember(Chairman chairman, MemberList ml) throws InterruptedException {
   
   
        boolean sentinel = false;
        int ID = 0;
        
        Thread.sleep(SHORTPAUSE);
        System.out.println(CLEARCONSOLE);
        
        do {
             
            System.out.print("\nWhose information would you like to change?\nMember ID: ");
            ID = Integer.parseInt(scan.next());
        
            if (chairman.findMember(ID, ml))  { System.out.println("\n\n"+ml.findMember(ID).getName()+" corresponds to this ID.\n\n"); sentinel = false; }
            else { System.out.println ("\n\nUser not found :(\n\n"); Thread.sleep(SHORTPAUSE); sentinel = true; } //add go back option!
            } while (sentinel);
        
        Thread.sleep(SHORTPAUSE);    
        System.out.println(ml.findMember(ID));    
        System.out.println("\n\nWhat would you like to change?\n");
        System.out.println("\n\nCHOOSE [1], [2], [3] OR [4].\n\n  1. NAME\n  2. ADDRESS\n  3. PREFERRED DISCIPLINE\n  4. EXERCISE TYPE\n  5. MEMBERSHIP LEVEL\n\n\n");
        
            switch (Integer.parseInt(scan.next())) {
            
                case 1:
                    System.out.print("\nPlease enter the member's new NAME: ");
                    try { String n = scan.next(); ml.findMember(ID).setName(n); } catch (Exception e) { System.out.println("\nInvalid input!!\n"); return; }
                    break;
                
                case 2:
                    System.out.print("\nPlease enter the member's new ADDRESS: ");
                    try { String a = scan.next(); ml.findMember(ID).setAddress(a); } catch (Exception e) { System.out.println("\nInvalid input!!\n"); return; }
                    break;
                    
                case 3:
                    System.out.println("\nPlease select the member's new PREFERRED DISCIPLINE: ");
                    System.out.println("\n\n  1. BREASTSTROKE\n  2. FRONTCRAWL\n  3. BACKSTROKE\n  4. BUTTERFLY\n\n\n");
                    
                        switch (Integer.parseInt(scan.next())) {
                        
                            case 1:
                                 ml.findMember(ID).setDiscipline("BREASTSTROKE");
                                 break;
                            case 2:
                                 ml.findMember(ID).setDiscipline("FRONTCRAWL");
                                 break;
                            case 3:
                                 ml.findMember(ID).setDiscipline("BACKSTROKE");
                                 break;
                            case 4:
                                 ml.findMember(ID).setDiscipline("BUTTERFLY");
                                 break;
                            default:
                                 System.out.println("\nInvalid input!!\n");
                                 return;
                          }
                     break;
                     
                case 4:
                    System.out.println("\nPlease enter the member's new EXERCISE TYPE: ");
                    System.out.println("\n\n  1. EXERCISE\n  2. ELITE\n\n\n");
                    
                        switch(Integer.parseInt(scan.next())) {
                        
                            case 1:
                                ml.findMember(ID).setType("EXERCISE"); 
                                break;
                            case 2:
                                ml.findMember(ID).setType("ELITE");
                                break;
                            default:
                                System.out.println("\nInvalid input!!\n");
                                return;

                        } 
                    
                    break;
                    
                case 5:
                    System.out.println("\nPlease enter the member's new MEMBERSHIP LEVEL: ");
                    System.out.println("\n\n  1. ACTIVE\n  2. PASSIVE\n\n\n");
                    
                    switch (Integer.parseInt(scan.next())) {  
                        case 1:
                            ml.findMember(ID).setActivityLevel(true);
                            ml.findMember(ID).setMembershipPrice(); //updating the price
                            break;
                        case 2:
                            ml.findMember(ID).setActivityLevel(false);
                            ml.findMember(ID).setMembershipPrice(); //updating the price
                            break;
                        default:
                            System.out.println("\nInvalid input!!\n");
                            return;
                     }
                     break;
                    
                default:
                    System.out.println("\nInvalid input!!\n");
                    return;   
            
            
            } //add confirmation

   }
 
//add try-catch   
   public static void newPayment(Treasurer treasurer, MemberList ml) throws InterruptedException {

        boolean sentinel = false;
        
           
        
            System.out.println("\n\nWhich member?\n\nMember ID: ");
            int ID = Integer.parseInt(scan.next());
        
            if (!treasurer.findMember(ID, ml))  { System.out.println("\n\nUser not found :(\n\n"); return; }

            System.out.println(ml.findMember(ID).getName()+" has "+treasurer.memberPrice(ml.findMember(ID), ml)+" left to pay.");
            
            if (ml.findMember(ID).getValidity()) { System.out.println("\n\nNothing to do here... \n\n"); Thread.sleep(SHORTPAUSE); return; }
            
            do {
            
            System.out.println("\n\nWould you like to add a new payment? [Y] or [N]\n\n"); //there should be a payment file but we don't have it yet
            
            sentinel = false;
            
            switch (scan.next().toUpperCase()) {
            
                case "Y":
                    System.out.println("\n\nHow is the payment being received?\n");
                    System.out.println("\n\n  1. CASH\n  2. CREDIT CARD\n  3. MOBILEPAY\n\n\n"); //this info would go in the payment history file although it's useless now
                    
                    switch (Integer.parseInt(scan.next())) {
                        case 1:
                            treasurer.registerPayment("CASH", ml.findMember(ID), ml);
                            break;
                        case 2:
                            treasurer.registerPayment("CREDIT CARD", ml.findMember(ID), ml);
                            break;
                        case 3:
                            treasurer.registerPayment("MOBILEPAY", ml.findMember(ID), ml);
                            break;
                        default:
                            sentinel = true;
                            System.out.println("\nInvalid input!!\n");
                            
                    }

                    break;
                    
                case "N":
                    return;
                    
                default:
                    sentinel = true;
                    System.out.println("\nInvalid input!!\n");
  
            
            }
            
            } while (sentinel);
            
            System.out.println("\n\nPayment updated successfully!\n\n");
            
   
   }

//add try-catch   
   public static void newResult(Coach coach, MemberList ml, ResultsList rl) throws InterruptedException { 
   
        boolean sentinel = false;
        
        int ID=0;
        double time=0.0;
        
        System.out.print("\n\nCreating a new result...\n\n\n");
        
        Result result = new Result();
       
        Thread.sleep(SHORTPAUSE);
        System.out.println(CLEARCONSOLE);
        
        do {
            sentinel = false; 
            System.out.print("\nMember ID for the new result: ");
            ID = Integer.parseInt(scan.next());
        
            if (coach.findMember(ID, ml))  { System.out.println("\n\n"+ml.findMember(ID).getName()+" corresponds to this ID.\n\n"); sentinel = false; }
            else { System.out.println ("\n\nUser not found :(\n\n"); Thread.sleep(SHORTPAUSE); sentinel = true; } //add go back option!
            } while (sentinel);
            
        Thread.sleep(SHORTPAUSE);
        

        result.setID(ID);
       
        System.out.println("\nCompetition or a training session?\n");
        System.out.println("\n\n  1. COMPETITIVE\n  2. TRAINING\n\n\n");
       
        switch (Integer.parseInt(scan.next())) {  
             case 1:
                result.setType(true);
                break;
             case 2:
                result.setType(false);
                break;
             default:
                 System.out.println("\nInvalid input!!\n");
                 return;
         }
         
        System.out.println("\nWhat distance?\n");
        System.out.println("\n\n  1. 100m\n  2. 200m\n  3. 400m\n\n\n");

        switch (Integer.parseInt(scan.next())) {  
             case 1:
                result.setDistance(100);
                break;
             case 2:
                result.setDistance(200);
                break;
             case 3:
                result.setDistance(400);
                break;
             default:
                 System.out.println("\nInvalid input!!\n");
                 return;
         }
         
         System.out.print("\nWhat is the recorded time? [00.00] ");
         
         try { time = Double.parseDouble(scan.next()); } catch (Exception e) { System.out.println("\nInvalid input!!\n"); return; }
         
         result.setTime(time);
         
         System.out.println("\nWhat discipline?");
         System.out.println("\n\n  1. BREASTSTROKE\n  2. FRONTCRAWL\n  3. BACKSTROKE\n  4. BUTTERFLY\n\n\n");
                    
                        switch (Integer.parseInt(scan.next())) {
                        
                            case 1:
                                 result.setDiscipline(1);
                                 result.setDiscipline2(1);
                                 break;
                            case 2:
                                 result.setDiscipline(2);
                                 result.setDiscipline2(2);
                                 break;
                            case 3:
                                 result.setDiscipline(3);
                                 result.setDiscipline2(3);
                                 break;
                            case 4:
                                 result.setDiscipline(4);
                                 result.setDiscipline2(4);
                                 break;
                            default:
                                 System.out.println("\nInvalid input!!\n");
                                 return;
                                 
                          }
                          
           System.out.println("\nThis is the information you entered: \n\n");
           System.out.println(result.newResultSummary(ml));
           Thread.sleep(SHORTPAUSE);
           
           do {
           
           sentinel = false;
           
           System.out.println("\nConfirm? [Y] or [N]\n\n");
           
           switch (scan.next().toUpperCase()) {
                case "Y":
                    coach.enterResult(result, rl); //method located in Coach
                    break;
                case "N":
                    System.out.println("\nExiting to home screen...\n");
                    return;
                default:
                    System.out.println("\nInvalid input!!\n");
                    sentinel = true;
           }
           
           } while (sentinel);
           
           System.out.println("\n\nThe new result was added successfully!\n\n");
           Thread.sleep(SHORTPAUSE);

   }
   
   public static void seeTop(Coach coach, ResultsList rl) {
   
        int disc=0, dist=0;
   
        System.out.print("Discipline: ");
        disc = scan.nextInt();
        System.out.print("Distance: ");
        dist = scan.nextInt();
        
        coach.viewDisciplineRank(dist, disc, rl);

       
   }
   
   


}