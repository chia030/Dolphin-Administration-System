public enum UserType {
    
//  TEMPLATE FOR THE ENUM: <EMPLOYEE>(<ID>, <PIN>) 

    CHAIRMAN(1, 1111), TREASURER(2, 2222), COACH(3, 3333);
    
    private final int userID;
    private final int userPIN;
    
    UserType(int ID, int PIN) {
    
        userID = ID;
        userPIN = PIN;
    
    }
    
    public int getID() { return userID; }
    
    public int getPIN() { return userPIN; }

}