public class Treasurer extends Employee {

    public Treasurer() {

        super(UserType.TREASURER);
    
    }


    public void registerPayment() {}
    
    
   public void printUnpaidPaid () throws FileNotFoundException {
        MemberList ml = new MemberList(); //the memberlist cannot be instantiated here!
        ml.scanFile();
        ml.printUnpaidPaid();
    }

}
