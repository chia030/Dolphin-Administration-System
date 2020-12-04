import java.io.FileNotFoundException;

//the IDs for the Employees will be:
// - CHAIRMAN = 1
// - TREASURER = 2
// - COACH = 3

public abstract class Employee {

        private int ID;
        private int PIN;
        private UserType type; //this is an ENUM
        
        
        //CONSTRUCTOR TAKING ENUM AS A PARAMETER:
        public Employee(UserType u) {
        
            this.ID = u.getID();
            this.PIN = u.getPIN();
            this.type = u;
        
        }

        public int getID() { return this.ID; }
        public void setID(int ID) { this.ID = ID;}
        

        public int getPIN() { return this.PIN;}
        public void setPIN(int PIN) { this.PIN = PIN; }
        
        
        public UserType getType() { return this.type; }        
        public void setType(UserType u) { this.type = u; }
        
       
        //SHOW MEMBERLIST METHOD: (the method is now very fluid and will adapt itself to the usertype that's logged in, given that it works lmao)
        public void showMemberList(MemberList ml) {
             
             switch(this.type) {
             
                case CHAIRMAN:
                    ml.printMembers(); //the member list should display the members alongside numbers (so the chairman can select them easily!)
                    break;
                    
                case TREASURER:
                    ml.printTrList();
                    break;
                    
                case COACH:
                    ml.printMembers(); //this is only temporary, the coach will have its own list too!
                    break;
                
                default:
                    System.out.println("You don't have access to this data!");

             }
             
        }


    }


