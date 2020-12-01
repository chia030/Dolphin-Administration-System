public class DAS {

   public static boolean sentinelDAS = false;

   public static void main(String[] args) throws InterruptedException {
   
      
      do {
         
         sentinelDAS = false;
         
         DAS_INTERFACE das = new DAS_INTERFACE();
         das.systemStart();
      
         DAS_INTERFACE logged = new DAS_INTERFACE(das.userTYPE);
         logged.userInterface();
      
      
      } while(sentinelDAS);
      
      
   
   
   }

}