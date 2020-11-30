import java.io.FileNotFoundException;

//the IDs for the Employees will be:
// - CHAIRMAN = 1
// - TREASURER = 2
// - COACH = 3

public class Employee {

        private int ID;
        private int PIN;
        private UserType type; //this is an ENUM
        
        
        //CONSTRUCTOR TAKING ENUM AS A PARAMETER:
        public Employee(UserType u) {
        
            this.ID = u.getID();
            this.PIN = u.getPIN();
            this.type = u;
        
        }
        
//         WORK IN PROGRESS...
//         public void showMemberList() throws FileNotFoundException {
//             MemberList ml = new MemberList();
//             ml.scanFile();
//             ml.printMembers();
//         }

        public int getID() { return this.ID; }
        public void setID(int ID) { this.ID = ID;}
        

        public int getPIN() { return this.PIN;}
        public void setPIN(int PIN) { this.PIN = PIN; }
        
        
        public UserType getType() { return this.type; }        
        public void setType(UserType u) { this.type = u; }


    }


