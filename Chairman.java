public class Chairman extends Employee {

    public Chairman() {
     
        super(UserType.CHAIRMAN);
     
     }

    public void registerMember() {}
   
    public void deleteMember() {}
   
    public void editMember() {}
   
    public void assignCoach() {}
    
    public void showMemberList() throws FileNotFoundException {
             MemberList ml = new MemberList(); //the memberlist cannot be instantiated here!
             ml.scanFile();
             ml.printMembers();
         }

}
