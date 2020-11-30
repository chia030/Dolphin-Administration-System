public class DAS {

   public static void main(String[] args) throws InterruptedException {
   
      boolean sentinel = false;
      
      do { //this loop does not do anything at the moment, it would be useful to log off in the future

      DAS_INTERFACE das = new DAS_INTERFACE();
   
      das.systemStart();
//      System.out.println(das.userID+" "+das.userPIN); //twas a test

      DAS_INTERFACE logged = new DAS_INTERFACE(das.userTYPE);
      
      
      } while(sentinel);
      
      
   
   
   }

}