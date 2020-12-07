import java.io.*;
public class DAS {

   public static boolean sentinelDAS = false;
   
   public static final String MEMBERLISTFILE = "lists/MemberList.txt";
   public static final String RESULTLISTFILE = "lists/ResultList.txt";
   
   
   

   public static void main(String[] args) throws InterruptedException, FileNotFoundException {
   
      
      do {
         
         sentinelDAS = false;
         
         DAS_INTERFACE das = new DAS_INTERFACE();
         das.systemStart();
      
         DAS_INTERFACE logged = new DAS_INTERFACE(das.userTYPE);
         logged.userInterface();

      } while(sentinelDAS);
      

   }

}