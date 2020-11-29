import java.io.FileNotFoundException;

public class Employee {

        private int ID;
        private int pin;
        private String type;

        public void showMemberList() throws FileNotFoundException {
//            MemberList ml = new MemberList();
//            ml.scanFile();
//            ml.printMembers();
        }

        public int getID() { return this.ID; }

        public void setID(int ID) { this.ID = ID;}

        public int getPin() { return this.pin;}

        public void setPin(int pin) { this.pin = pin; }

        public String getType() { return this.type; }

        public void setType(String type) { this.type = type; }

    }
