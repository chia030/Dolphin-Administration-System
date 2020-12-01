public class Treasurer extends Employee {

    public Treasurer() {

        super(UserType.TREASURER);
    
    }


    public void registerPayment() {}
    
    public void showUnpaidMembers () throws FileNotFoundException {
        MemberList ml = new MemberList();
        ml.scanFile();
        ml.printUnpaid();
    }
    
    public void showPaidMembers () throws FileNotFoundException {
        MemberList ml = new MemberList();
        ml.scanFile();
        ml.printPaid();
    }

}
