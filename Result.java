import java.time.format.DateTimeFormatter;
import java.time.*;

public class Result {
    private String type;
    private String distance;   
    private String name;
    private String time;
    private String date;
    private String discipline;
    private String ID;

// new result vars
    
    public boolean typ; //true = competition, false = training
    public int dist;
    public LocalDate ddate;
    public double tim;
    public String disc; //maybe string in the future
    public Member mem;
    public int mID;
    
    
    // enterResult() new constructor
    public Result(int mID, boolean typ, int discip, double tim, int disc) {
    
        this.mID = mID;
        this.typ = typ;
        this.dist = dist;
        this.tim = tim;
        switch (discip) {
            case 1: this.disc = "BREASTSTROKE"; break;
            case 2: this.disc = "FRONTCRAWL"; break;
            case 3: this.disc = "FRONTCRAWL"; break;
            case 4: this.disc = "BUTTERFLY"; break;        
        }
        this.ddate = LocalDate.now();
    
    }
    
    //resultlist new constructor
    public Result(int mID, boolean typ, int dist, double tim, int discip, LocalDate ddate) {
    
        this.mID = mID;
        this.typ = typ;
        this.dist = dist;
        this.tim = tim;
        switch (discip) {
            case 1: this.disc = "BREASTSTROKE"; break;
            case 2: this.disc = "FRONTCRAWL"; break;
            case 3: this.disc = "FRONTCRAWL"; break;
            case 4: this.disc = "BUTTERFLY"; break;        
        }
        this.ddate = ddate;
    
    }
     

    //constructor when creating a result //I made a new one!
    public Result(String type, String name, String ID, String distance,String time, String discipline){
        this.type = type;
        this.distance = distance;
        this.ID = ID;
        this.name = name;
        this.time = time;
        this.discipline = discipline;
        setDate();
    }
    
    

    //constructor when reading from a file //I made a new one!
    public Result(String type, String name, String ID, String date, String time, String distance,String discipline){
        this.distance = distance;
        this.type = type;
        this.ID = ID;
        this.name = name;
        this.time = time;
        this.discipline = discipline;
        this.date = date;
    }

    //construct needed when entering a result
    public Result(){

    }


    //getters and setters
    public void setDistance(String distance){
        this.distance = distance;
    }

    public String getDistance(){
        return distance;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public void setID(String ID){
        this.ID = ID;
    }

    public String getID(){
        return ID;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setTime(String time){
        this.time = time;    
    }

    public String getTime(){
        return time;
    }

    public void setDate(){
        date = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(LocalDate.now());
    }

    public String getDate(){
        return date;
    }

    public void setDiscipline(String discipline){
        this.discipline = discipline;
    }

    public String getDiscipline(){
        return discipline;
    }
    
    public String isCompetitive() {
    
        if (this.typ) return "COMPETITIVE";
        return "TRAINING"; //if not
    }

    //turn all info into string
//     public String toString(){
//         return getName()+" \n"+getType()+" \n"+getID()+"\n"+getDate()+"\n"+getTime()+"\n"+getDistance()+"\n"+getDiscipline();
//     }

    public String toString() { //I had to make a new toString()
    
        return "\n"+this.mID+"\n"+this.isCompetitive()+"\n"+this.dist+"m\n"+this.tim+"\n"+this.disc+"\n"+this.ddate+"\n\n\n";
    
    }

}
