import java.time.*;

public class Member {

    private int ID;
    private String name;
    private int age; 
    private String address;
    private String discipline;
    private LocalDate regDate;
    private String type;
    private String ageRange;
    private boolean validity;
    private boolean activityLevel;

    //added a simple constructor
    public Member(int newID, String newName, int newAge, String newAddress, String newDiscipline, String newType, boolean newValidity, boolean newActivityLevel){
      ID = newID;
      name = newName;
      age = newAge;
      address = newAddress;
      discipline = newDiscipline;
      type = newType;
      validity = newValidity;
      activityLevel = newActivityLevel;
      if (age < 19){
         ageRange = "Junior";
      }else ageRange = "Senior";
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public boolean getValidity() {
        return validity;
    }

    public void setValidity(boolean validity) {
        this.validity = validity;
    }

    public boolean getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(boolean activityLevel) {
        this.activityLevel = activityLevel;
    }

}